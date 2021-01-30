package com.justint.usdidea.lang.psi.impl;

import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.util.UserDataCache;
import com.intellij.psi.*;

import com.intellij.psi.util.CachedValue;
import com.intellij.psi.util.CachedValueProvider;
import com.intellij.psi.util.CachedValuesManager;
import com.intellij.util.ProcessingContext;
import com.intellij.util.SmartList;
import com.justint.usdidea.lang.psi.USDReferenceReference;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class USDReferenceReferenceProvider extends PsiReferenceProvider {
    public static final USDReferenceReferenceProvider INSTANCE = new USDReferenceReferenceProvider();

    private static final Pattern referencePattern = Pattern.compile("((@.*@)|(@.*@)?(<.*>))");

    @NotNull
    @Override
    public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
        List<PsiReference> refs = null;
        String text = element.getText();
        Matcher matcher = referencePattern.matcher(text);

        if (matcher.matches()) {
            refs = new SmartList<>();
            TextRange textRange = new TextRange(0, text.length());
            refs.add(new USDReferenceReference(element, textRange));
        }

        return refs != null ? refs.toArray(PsiReference.EMPTY_ARRAY) : PsiReference.EMPTY_ARRAY;
    }
}
