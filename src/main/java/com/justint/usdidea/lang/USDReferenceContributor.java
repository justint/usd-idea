package com.justint.usdidea.lang;

import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiReferenceContributor;
import com.intellij.psi.PsiReferenceRegistrar;
import com.justint.usdidea.lang.psi.impl.USDReferenceReferenceProvider;
import com.justint.usdidea.lang.psi.usdReferenceItem;
import org.jetbrains.annotations.NotNull;

public class USDReferenceContributor extends PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(usdReferenceItem.class), USDReferenceReferenceProvider.INSTANCE);
    }
}
