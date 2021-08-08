package com.justint.usdidea.codeinsight;

import com.intellij.lang.Language;
import com.intellij.psi.PsiElement;
import com.intellij.ui.breadcrumbs.BreadcrumbsProvider;
import com.justint.usdidea.lang.USDLanguage;
import com.justint.usdidea.lang.psi.USDBreadcrumbItem;
import com.justint.usdidea.lang.psi.USDFile;
import com.justint.usdidea.lang.psi.usdPrimSpec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;

public class USDBreadcrumbsProvider implements BreadcrumbsProvider {

    @Override
    public Language[] getLanguages() {
        return new Language[]{USDLanguage.INSTANCE};
    }

    @Override
    public boolean acceptElement(@NotNull PsiElement psiElement) {
        return (psiElement instanceof USDBreadcrumbItem);
    }

    @NotNull
    @Override
    public String getElementInfo(@NotNull PsiElement psiElement) {
        return ((USDBreadcrumbItem)psiElement).getName();
    }

    // TODO: implement these
//    @Nullable
//    @Override
//    public Icon getElementIcon(@NotNull PsiElement element) {
//        return null;
//    }
//
    @Nullable
    @Override
    public String getElementTooltip(@NotNull PsiElement element) {
        return String.join(" ", USDDocumentationProvider.getUSDPsiElementDocStringArray(element));
    }
}
