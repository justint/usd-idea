package com.justint.usdidea.lang;

import com.intellij.ide.structureView.StructureView;
import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.TreeBasedStructureViewBuilder;
import com.intellij.lang.PsiStructureViewFactory;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class USDStructureViewFactory implements PsiStructureViewFactory {

    @Nullable
    @Override
    public StructureViewBuilder getStructureViewBuilder(@NotNull PsiFile psiFile) {
        return new TreeBasedStructureViewBuilder() {
            @NotNull
            @Override
            public StructureViewModel createStructureViewModel(@Nullable Editor editor) {
                return new USDStructureViewModel(psiFile);
            }

            @NotNull
            @Override
            public StructureView createStructureView(@Nullable FileEditor fileEditor, @NotNull Project project) {
                if (fileEditor == null) {
                    FileEditor[] editors = FileEditorManager.getInstance(project).getAllEditors();
                    for (FileEditor editor : editors) {
                        String filePath = editor.getFile().getPath();
                        if (psiFile.getVirtualFile().getPath().equals(filePath)) {
                            fileEditor = editor;
                            break;
                        }
                    }
                }
                return super.createStructureView(fileEditor, project);
            }
        };
    }
}
