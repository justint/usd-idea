package com.justint.usdidea.lang.psi;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;

import com.justint.usdidea.file.USDBinaryFile;
import com.justint.usdidea.lang.USDLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class USDFileViewProvider extends SingleRootFileViewProvider {

    public USDFileViewProvider(@NotNull PsiManager manager, @NotNull VirtualFile file) {
        this(manager, file, true, USDLanguage.INSTANCE);
    }

    public USDFileViewProvider(@NotNull PsiManager manager, @NotNull VirtualFile virtualFile, boolean eventSystemEnabled, @NotNull Language language) {
        super(manager, virtualFile, eventSystemEnabled, language);
        System.out.println("new file view provider for: " + virtualFile.getName());
    }

    @Nullable
    @Override
    protected PsiFile createFile(@NotNull Project project, @NotNull VirtualFile file, @NotNull FileType fileType) {
        System.out.println("Creating new file: " + file.getName());
        return new USDBinaryFile( this);
    }
}