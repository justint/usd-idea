package com.justint.usdidea.codeinsight.highlighting;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.justint.usdidea.lang.psi.USDTypes.*;

public class USDBraceMatcher implements PairedBraceMatcher {

    private static final BracePair[] PAIRS = new BracePair[] {
            new BracePair(LEFTBRACE, RIGHTBRACE, true),
            new BracePair(LEFTPARENS, RIGHTPARENS, true),
            new BracePair(LEFTBRACKET, RIGHTBRACKET, false)
    };

    @NotNull
    @Override
    public BracePair[] getPairs() {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lBraceType, @Nullable IElementType contextType) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}
