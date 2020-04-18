package com.justint.usdidea.fileEditor;

import com.intellij.openapi.fileEditor.*;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.justint.usdidea.lang.psi.USDFile;
import org.jetbrains.annotations.NotNull;


public class USDFileEditorProvider implements FileEditorProvider {

    @Override
    public boolean accept(@NotNull Project project, @NotNull VirtualFile virtualFile) {
        if (!virtualFile.isValid()) {
            return false;
        }

        final PsiFile psiFile = PsiManager.getInstance(project).findFile(virtualFile);

        if (!(psiFile instanceof USDFile)) {
            return false;
        }

        final Module module = ModuleUtilCore.findModuleForFile(virtualFile, project);
        if (module == null) {
            return false;
        }

        return true;
    }

    @NotNull
    @Override
    public FileEditor createEditor(@NotNull Project project, @NotNull VirtualFile virtualFile) {
        return new USDFileEditor(project, virtualFile);
    }

    @NotNull
    @Override
    public String getEditorTypeId() {
        return "USDFileEditor";
    }

    @NotNull
    @Override
    public FileEditorPolicy getPolicy() {
        return FileEditorPolicy.HIDE_DEFAULT_EDITOR;
    }
}
