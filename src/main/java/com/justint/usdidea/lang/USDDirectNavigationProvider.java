package com.justint.usdidea.lang;

import com.intellij.navigation.DirectNavigationProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class USDDirectNavigationProvider implements DirectNavigationProvider {
    @Nullable
    @Override
    public PsiElement getNavigationElement(@NotNull PsiElement psiElement) {
        return null;
    }
}
