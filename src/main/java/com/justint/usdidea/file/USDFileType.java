package com.justint.usdidea.file;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.vfs.VirtualFile;
import com.justint.usdidea.fileEditor.USDFileEditor;
import com.justint.usdidea.util.USDIcons;
import com.justint.usdidea.lang.USDLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class USDFileType implements FileType {
    public static final USDFileType INSTANCE = new USDFileType();

    @NotNull
    @Override
    public String getName() {
        return "USD";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Universal Scene Description File";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "usd";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return USDIcons.FILE;
    }

    @Override
    public boolean isBinary() {
        return true;
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Nullable
    @Override
    public String getCharset(@NotNull VirtualFile virtualFile, @NotNull byte[] bytes) {
//        return USDA_INSTANCE.getCharset(virtualFile, bytes);
        return null;
    }
}
