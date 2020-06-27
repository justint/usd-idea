package com.justint.usdidea.lang.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public interface USDBreadcrumbItem extends PsiElement {

    @NotNull
    String getName();
}
