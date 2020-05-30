package com.justint.usdidea.lang;

import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.*;
import com.intellij.psi.PsiFile;
import com.intellij.util.PlatformIcons;
import com.justint.usdidea.lang.psi.USDFile;
import gherkin.lexer.Pl;
import org.jetbrains.annotations.NotNull;

public class USDStructureViewModel extends StructureViewModelBase
        implements StructureViewModel.ElementInfoProvider {

    Filter PropertyFilter = new Filter() {
        @Override
        public boolean isVisible(TreeElement treeElement) {
            return treeElement.getPresentation().getIcon(true) != PlatformIcons.PROPERTY_ICON;
        }

        @Override
        public boolean isReverted() {
            return true;
        }

        @NotNull
        @Override
        public ActionPresentation getPresentation() {
            return new ActionPresentationData("Show Properties", "Show Properties", PlatformIcons.PROPERTY_ICON);
        }

        @NotNull
        @Override
        public String getName() {
            return "USD_PROPERTY_FILTER";
        }
    };

    public USDStructureViewModel(PsiFile psiFile) {
        super(psiFile, new USDStructureViewElement(psiFile));
    }

    @NotNull
    public Sorter[] getSorters() {
        return new Sorter[]{Sorter.ALPHA_SORTER};
    }

    @NotNull
    @Override
    public Filter[] getFilters() {
        return new Filter[]{PropertyFilter};
    }

    @Override
    public boolean isAlwaysShowsPlus(StructureViewTreeElement structureViewTreeElement) {
        return false;
    }

    @Override
    public boolean isAlwaysLeaf(StructureViewTreeElement structureViewTreeElement) {
        return structureViewTreeElement instanceof USDFile;
    }

}