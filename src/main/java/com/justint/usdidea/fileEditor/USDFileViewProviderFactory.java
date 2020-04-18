package com.justint.usdidea.fileEditor;

import com.intellij.lang.Language;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.FileViewProviderFactory;
import com.intellij.psi.PsiManager;
import com.justint.usdidea.lang.USDLanguage;
import com.justint.usdidea.lang.psi.USDFileViewProvider;
import org.jetbrains.annotations.NotNull;

public class USDFileViewProviderFactory implements FileViewProviderFactory {

    @NotNull
    @Override
    public FileViewProvider createFileViewProvider(@NotNull VirtualFile virtualFile, Language language, @NotNull PsiManager psiManager, boolean eventSystemEnabled) {
        return new USDFileViewProvider(psiManager, virtualFile, eventSystemEnabled, USDLanguage.INSTANCE);
    }
}
