package com.justint.usdidea.codeinsight;

import com.intellij.lang.Language;
import com.intellij.psi.PsiElement;
import com.intellij.ui.breadcrumbs.BreadcrumbsProvider;
import com.justint.usdidea.lang.USDLanguage;
import com.justint.usdidea.lang.psi.impl.usdPrimSpecImpl;
import org.jetbrains.annotations.NotNull;

public class USDBreadcrumbsProvider implements BreadcrumbsProvider {

    @Override
    public Language[] getLanguages() {
        return new Language[]{USDLanguage.INSTANCE};
    }

    @Override
    public boolean acceptElement(@NotNull PsiElement psiElement) {
        return psiElement instanceof usdPrimSpecImpl;
    }

    @NotNull
    @Override
    public String getElementInfo(@NotNull PsiElement psiElement) {
        if (psiElement instanceof usdPrimSpecImpl) {
            return ((usdPrimSpecImpl) psiElement).getName();
        }
        else return "";
    }
}
