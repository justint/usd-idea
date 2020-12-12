package com.justint.usdidea.lang;

import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.justint.usdidea.lang.psi.*;
import com.justint.usdidea.lang.psi.impl.*;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Function;

public class USDStructureViewElement implements StructureViewTreeElement, SortableTreeElement {
    private final NavigatablePsiElement myElement;

    private final Map<Class<? extends PsiElement>, Function<NavigatablePsiElement, TreeElement[]>> psiElementMethodMap = Map.of(
            USDFile.class, this::getUSDFileChildren,
            usdPrimSpecImpl.class, this::getPrimSpecChildren,
            usdMetadatumImpl.class, this::getMetadatumChildren,
            usdDictItemImpl.class, this::getDictItemChildren,
            usdPropertySpecImpl.class, this::getPropertySpecChildren,
            usdRelationshipPropertyImpl.class, this::getRelationshipPropertyChildren,
            usdVariantSetKeyImpl.class, this::getVariantSetKeyChildren
    );


    public USDStructureViewElement(NavigatablePsiElement element) {
        this.myElement = element;
    }

    @Override
    public Object getValue() {
        return myElement;
    }

    @NotNull
    @Override
    public String getAlphaSortKey() {
        String name = myElement.getName();
        return name != null ? name : "";
    }

    @NotNull
    @Override
    public ItemPresentation getPresentation() {
        ItemPresentation presentation = myElement.getPresentation();
        return presentation != null ? presentation : new PresentationData();
    }

    @NotNull
    private TreeElement[] getUSDFileChildren(NavigatablePsiElement element) {
        List<TreeElement> treeElements = new ArrayList<>();
        // Find any metadata first
        usdMetadata metadata = PsiTreeUtil.getChildOfType(element, usdMetadata.class);
        if (metadata != null) {
            for (usdMetadatum metadatum : metadata.getMetadatumList()) {
                treeElements.add(new USDStructureViewElement((usdMetadatumImpl) metadatum));
            }
        }

        // Find all prim specs, include them
        List<usdPrimSpec> prims = PsiTreeUtil.getChildrenOfTypeAsList(element, usdPrimSpec.class);
        for (usdPrimSpec prim : prims) {
            treeElements.add(new USDStructureViewElement((usdPrimSpecImpl) prim));
        }
        return treeElements.toArray(new TreeElement[0]);
    }

    @NotNull
    private TreeElement[] getPrimSpecChildren(NavigatablePsiElement element) {
        List<TreeElement> treeElements = new ArrayList<>();
        // Find metadata children first
        usdMetadata metadata = ((usdPrimSpec)element).getMetadata();
        if (metadata != null) {
            for (usdMetadatum metadatum : metadata.getMetadatumList()) {
                treeElements.add(new USDStructureViewElement((usdMetadatumImpl) metadatum));
            }
        }

        // Grab prim body children next
        usdBody body = ((usdPrimSpec)element).getBody();
        if (body != null) {
            for (PsiElement child : body.getChildren()) {
                if (child instanceof usdPrimSpec) {
                    treeElements.add(new USDStructureViewElement((usdPrimSpecImpl) child));
                } else if (child instanceof usdPropertySpec) {
                    treeElements.add(new USDStructureViewElement((usdPropertySpecImpl) child));
                }
            }
        }
        return treeElements.toArray(new TreeElement[0]);
    }

    @NotNull
    private TreeElement[] getMetadatumChildren(NavigatablePsiElement element) {
        List<TreeElement> treeElements = new ArrayList<>();

        usdMetadataValue metadataValue = ((usdMetadatum)element).getMetadataValue();
        if (metadataValue != null) {
            if (metadataValue.getItem().getDict() != null) {
                usdDict dictionary = metadataValue.getItem().getDict();
                for (usdDictItem dictItem : dictionary.getDictItemList()) {
                    treeElements.add(new USDStructureViewElement((usdDictItemImpl) dictItem));
                }
            }
        }
        return treeElements.toArray(new TreeElement[0]);
    }

    @NotNull
    private TreeElement[] getDictItemChildren(NavigatablePsiElement element) {
        // The item may have children dictionaries
        if (((usdDictItem) element).isDictionary()) {
            List<TreeElement> treeElements = new ArrayList<>();
            usdDict childDictionary = ((usdDictItem) element).getDictValue().getItem().getDict();
            assert childDictionary != null;
            for (usdDictItem dictItem : childDictionary.getDictItemList()) {
                treeElements.add(new USDStructureViewElement((usdDictItemImpl) dictItem));
            }
            return treeElements.toArray(new TreeElement[0]);
        } else return EMPTY_ARRAY;
    }

    @NotNull
    private TreeElement[] getPropertySpecChildren(NavigatablePsiElement element) {
        usdRelationshipProperty relationshipProperty = PsiTreeUtil.findChildOfType(element, usdRelationshipProperty.class);
        if (relationshipProperty != null) {
            return getRelationshipPropertyChildren((NavigatablePsiElement) relationshipProperty);
        } else return EMPTY_ARRAY;
    }

    @NotNull
    private TreeElement[] getRelationshipPropertyChildren(NavigatablePsiElement element) {
        usdVariantSetBody variantSetBody = ((usdRelationshipProperty) element).getVariantSetBody();
        if (variantSetBody != null) {
            List<TreeElement> treeElements = new ArrayList<>();
            for (usdVariantSetKey variantSetKey : variantSetBody.getVariantSetKeyList()) {
                treeElements.add(new USDStructureViewElement((usdVariantSetKeyImpl) variantSetKey));
            }
            return treeElements.toArray(new TreeElement[0]);
        } else return EMPTY_ARRAY;
    }

    @NotNull
    private TreeElement[] getVariantSetKeyChildren(NavigatablePsiElement element) {
        usdVariantSetItemBody body = ((usdVariantSetKey)element).getBody();

        // Treat the body of the variant as a new file, and grab all its children as so:
        return getUSDFileChildren((NavigatablePsiElement) body);
    }

    @NotNull
    @Override
    public TreeElement[] getChildren() {
        Class<? extends NavigatablePsiElement> elementType = myElement.getClass();
        if (psiElementMethodMap.containsKey(elementType)) {
            return psiElementMethodMap.get(elementType).apply(myElement);
        }
        else return EMPTY_ARRAY;
        // Debug info:
//        else {
//            System.out.println(myElement.getName() + "  --  type: " + myElement.getClass());
//            for (PsiElement child : myElement.getChildren()) {
//                System.out.println("\t" + child.getText() + " -- type: " + child.getClass());
//            }
//        }
    }

    @Override
    public void navigate(boolean requestFocus) {
        myElement.navigate(requestFocus);
    }

    @Override
    public boolean canNavigate() {
        return myElement.canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return myElement.canNavigateToSource();
    }
}
