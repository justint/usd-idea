package com.justint.usdidea.file;

import com.intellij.openapi.fileEditor.*;
import com.intellij.openapi.fileEditor.impl.text.TextEditorProvider;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;

public class USDFileEditorProvider implements AsyncFileEditorProvider, DumbAware {

    private static final String EDITOR_TYPE_ID = "com.justint.usdidea";

    @Override
    public boolean accept(@NotNull Project project, @NotNull VirtualFile virtualFile) {
        return virtualFile.getExtension() != null && virtualFile.getExtension().equals("usd");
//        return (virtualFile.getFileType() instanceof USDFileType);
    }

    @NotNull
    @Override
    public FileEditor createEditor(@NotNull Project project, @NotNull VirtualFile virtualFile) {
        USDVirtualFile usdVirtualFile = USDVirtualFileSystem.getInstance().findUSDVirtualFile(virtualFile, project);

//        if (virtualFile instanceof USDVirtualFile) {
//            usdVirtualFile = (USDVirtualFile) virtualFile;
//        } else {
//            usdVirtualFile = new USDVirtualFile(virtualFile, project);
//        }

        assert usdVirtualFile != null;
        return TextEditorProvider.getInstance().createEditor(project, usdVirtualFile);

    }

    @NotNull
    @Override
    public String getEditorTypeId() {
        return EDITOR_TYPE_ID;
    }

    @NotNull
    @Override
    public FileEditorPolicy getPolicy() {
        return FileEditorPolicy.HIDE_DEFAULT_EDITOR;
    }

    @NotNull
    @Override
    public Builder createEditorAsync(@NotNull Project project, @NotNull VirtualFile virtualFile) {
        return new Builder() {
            @Override
            public FileEditor build() {
                return createEditor(project, virtualFile);
            }
        };
    }
}
