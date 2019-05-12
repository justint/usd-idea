package com.justint.usdidea.psi;

import com.intellij.psi.tree.IElementType;
import com.justint.usdidea.USDLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class USDTokenType extends IElementType {
    public USDTokenType(@NotNull @NonNls String debugName) {
        super(debugName, USDLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "USDTokenType." + super.toString();
    }
}
