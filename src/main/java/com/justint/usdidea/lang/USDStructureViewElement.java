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
import com.justint.usdidea.lang.psi.impl.usdDictItemImpl;
import com.justint.usdidea.lang.psi.impl.usdMetadatumImpl;
import com.justint.usdidea.lang.psi.impl.usdPrimSpecImpl;
import com.justint.usdidea.lang.psi.impl.usdPropertySpecImpl;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class USDStructureViewElement implements StructureViewTreeElement, SortableTreeElement {
    private final NavigatablePsiElement myElement;

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
    @Override
    public TreeElement[] getChildren() {
        if (myElement instanceof USDFile) {
            List<TreeElement> treeElements = new ArrayList<>();
            // Find any metadata first
            usdMetadata metadata = PsiTreeUtil.getChildOfType(myElement, usdMetadata.class);
            if (metadata != null) {
                for (usdMetadatum metadatum : metadata.getMetadatumList()) {
                    treeElements.add(new USDStructureViewElement((usdMetadatumImpl) metadatum));
                }
            }

            // Find all prim specs, include them
            List<usdPrimSpec> prims = PsiTreeUtil.getChildrenOfTypeAsList(myElement, usdPrimSpec.class);
            for (usdPrimSpec prim : prims) {
                treeElements.add(new USDStructureViewElement((usdPrimSpecImpl) prim));
            }
            return treeElements.toArray(new TreeElement[0]);
        }
        else if (myElement instanceof usdPrimSpec) {
            List<TreeElement> treeElements = new ArrayList<>();
            // Find metadata children first
            usdMetadata metadata = ((usdPrimSpec)myElement).getMetadata();
            if (metadata != null) {
                for (usdMetadatum metadatum : metadata.getMetadatumList()) {
                    treeElements.add(new USDStructureViewElement((usdMetadatumImpl) metadatum));
                }
            }

            // Grab prim body children next
            usdBody body = ((usdPrimSpec)myElement).getBody();
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
        else if (myElement instanceof usdMetadatum) {
            List<TreeElement> treeElements = new ArrayList<>();

            usdMetadataValue metadataValue = ((usdMetadatum)myElement).getMetadataValue();
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
        else if (myElement instanceof usdDictItem) {
            // The item may have children dictionaries
            if (((usdDictItem) myElement).isDictionary()) {
                List<TreeElement> treeElements = new ArrayList<>();
                usdDict childDictionary = ((usdDictItem) myElement).getDictValue().getItem().getDict();
                for (usdDictItem dictItem : childDictionary.getDictItemList()) {
                    treeElements.add(new USDStructureViewElement((usdDictItemImpl) dictItem));
                }
                return treeElements.toArray(new TreeElement[0]);
            } else return EMPTY_ARRAY;
        }
        // Debug info:
//        else {
//            System.out.println(myElement.getName() + "  --  type: " + myElement.getClass());
//            for (PsiElement child : myElement.getChildren()) {
//                System.out.println("\t" + child.getText() + " -- type: " + child.getClass());
//            }
//        }
        return EMPTY_ARRAY;
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
