package com.justint.usdidea.util;

import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class USDPsiTreeUtil {
    /**
     * Finds all parents of a given PsiElement with the same type.
     * @param element PsiElement to search parents for
     * @return List of PsiElement parents of {@param element} in hierarchical order (top->bottom)
     */
    @NotNull
    @SuppressWarnings("unchecked")
    public static <T extends PsiElement> List<T> findAllParentsOfSameType(PsiElement element) {
        if (element == null) return Collections.emptyList();

        List<T> parents = new ArrayList<>();
        T currentElement = (T) PsiTreeUtil.getParentOfType(element, element.getClass());
        while (currentElement != null) {
            parents.add(0, currentElement);
            currentElement = (T) PsiTreeUtil.getParentOfType(currentElement, currentElement.getClass());
        }
        return parents;
    }
}
