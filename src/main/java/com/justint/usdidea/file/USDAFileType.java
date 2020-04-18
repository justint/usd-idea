package com.justint.usdidea.file;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.justint.usdidea.lang.USDLanguage;
import com.justint.usdidea.util.USDIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class USDAFileType extends LanguageFileType {
    public static final USDAFileType INSTANCE = new USDAFileType();

    public USDAFileType() {
        super(USDLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "USDA";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Universal Scene Description ASCII File";
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
