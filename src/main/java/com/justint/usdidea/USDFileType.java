package com.justint.usdidea;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class USDFileType extends LanguageFileType {
    public static final USDFileType INSTANCE = new USDFileType();

    private USDFileType() {
        super(USDLanguage.INSTANCE);
    }

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
        return "usda";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return USDIcons.FILE;
    }
}
