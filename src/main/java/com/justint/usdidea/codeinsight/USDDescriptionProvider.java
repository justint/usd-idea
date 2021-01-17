package com.justint.usdidea.codeinsight;

import com.intellij.psi.ElementDescriptionLocation;
import com.intellij.psi.ElementDescriptionProvider;
import com.intellij.psi.PsiElement;
import com.intellij.usageView.UsageViewShortNameLocation;
import com.intellij.usageView.UsageViewTypeLocation;
import com.justint.usdidea.lang.psi.USDNamedElement;
import com.justint.usdidea.lang.psi.usdReferenceItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class USDDescriptionProvider implements ElementDescriptionProvider {

    @Nullable
    @Override
    public String getElementDescription(@NotNull PsiElement psiElement, @NotNull ElementDescriptionLocation elementDescriptionLocation) {
        if (elementDescriptionLocation instanceof UsageViewTypeLocation) {
            if (psiElement instanceof USDNamedElement) {
                return ((USDNamedElement) psiElement).getDescriptionName();
            }
        }
        else if (elementDescriptionLocation instanceof UsageViewShortNameLocation) {
            if (psiElement instanceof usdReferenceItem) {
                return psiElement.getText();
            }
        }
        return null;
    }
}
