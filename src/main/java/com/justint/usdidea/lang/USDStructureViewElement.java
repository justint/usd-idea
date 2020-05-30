package com.justint.usdidea.lang;

import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.justint.usdidea.lang.psi.USDFile;
import com.justint.usdidea.lang.psi.impl.usdPrimSpecImpl;
import com.justint.usdidea.lang.psi.impl.usdPropertySpecImpl;
import com.justint.usdidea.lang.psi.usdBody;
import com.justint.usdidea.lang.psi.usdPrimSpec;
import com.justint.usdidea.lang.psi.usdPropertySpec;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
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
            // Find all prim specs, include them
            List<usdPrimSpec> prims = PsiTreeUtil.getChildrenOfTypeAsList(myElement, usdPrimSpec.class);
            List<TreeElement> treeElements = new ArrayList<>(prims.size());
            for (usdPrimSpec prim : prims) {
                treeElements.add(new USDStructureViewElement((usdPrimSpecImpl) prim));
            }
            return treeElements.toArray(new TreeElement[0]);
        }
        else if (myElement instanceof usdPrimSpec) {
            // Grab child prims first
            usdBody body = ((usdPrimSpec)myElement).getBody();
            List<usdPrimSpec> childPrims = body.getPrimSpecList();

            // Next, grab properties defined in prim
            List<usdPropertySpec> childProperties = body.getPropertySpecList();

            // Add all the items into the tree
            List<TreeElement> treeElements = new ArrayList<>(childPrims.size() + childProperties.size());
            for (usdPrimSpec prim : childPrims) {
                treeElements.add(new USDStructureViewElement((usdPrimSpecImpl) prim));
            }
            for (usdPropertySpec property : childProperties) {
                treeElements.add(new USDStructureViewElement((usdPropertySpecImpl) property));
            }
            return treeElements.toArray(new TreeElement[0]);
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
