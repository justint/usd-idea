package com.justint.usdidea.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.justint.usdidea.USDFileType;
import com.justint.usdidea.USDLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class USDFile extends PsiFileBase {
    public USDFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, USDLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return USDFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Universal Scene Description";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
