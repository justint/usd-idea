package com.justint.usdidea.lang.psi;

import com.intellij.psi.tree.IElementType;
import com.justint.usdidea.lang.USDLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class USDElementType extends IElementType {
    public USDElementType(@NotNull @NonNls String debugName) {
        super(debugName, USDLanguage.INSTANCE);
    }
}
