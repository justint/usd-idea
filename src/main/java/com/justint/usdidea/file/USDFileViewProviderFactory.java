package com.justint.usdidea.file;

import com.intellij.lang.Language;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.justint.usdidea.lang.USDLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class USDFileViewProviderFactory implements FileViewProviderFactory {
    @NotNull
    @Override
    public FileViewProvider createFileViewProvider(@NotNull VirtualFile virtualFile, Language language, @NotNull PsiManager psiManager, boolean eventSystemEnabled) {
        return new USDFileViewProvider(psiManager, virtualFile, eventSystemEnabled);
    }

    public static class USDFileViewProvider extends SingleRootFileViewProvider {

        private USDVirtualFile myUSDVirtualFile;

        protected USDFileViewProvider(@NotNull PsiManager manager, @NotNull VirtualFile virtualFile, boolean eventSystemEnabled) {
            super(manager, virtualFile, eventSystemEnabled, USDLanguage.INSTANCE);

            myUSDVirtualFile = USDVirtualFileSystem.getInstance().findUSDVirtualFile(virtualFile, manager.getProject());
//
//            if (virtualFile instanceof USDVirtualFile) {
//                myUSDVirtualFile = (USDVirtualFile) virtualFile;
//            } else {
//                myUSDVirtualFile = new USDVirtualFile(virtualFile, manager.getProject());
//            }
        }

        @Override
        public boolean isPhysical() {
            return false;
        }

        @NotNull
        @Override
        public CharSequence getContents() {
            return myUSDVirtualFile.getContent();
        }

        @Override
        public Document getDocument() {
            Document document = FileDocumentManager.getInstance().getDocument(myUSDVirtualFile);
            return document;
        }
    }
}
