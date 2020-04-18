package com.justint.usdidea.file;

import com.intellij.lang.Language;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.DefaultProjectFactory;
import com.intellij.openapi.ui.Queryable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.impl.PsiFileEx;
import com.intellij.psi.impl.PsiManagerImpl;
import com.intellij.psi.impl.file.PsiBinaryFileImpl;
import com.intellij.psi.impl.source.PsiFileImpl;
import com.intellij.psi.impl.source.SourceTreeToPsiMap;
import com.intellij.psi.impl.source.tree.TreeElement;
import com.intellij.reference.SoftReference;
import com.intellij.util.AstLoadingFilter;
import com.justint.usdidea.lang.USDLanguage;
import com.justint.usdidea.lang.psi.USDFileViewProvider;
import com.justint.usdidea.util.USDCat;
import org.jetbrains.annotations.NotNull;

import java.lang.ref.Reference;

public class USDBinaryFile extends PsiBinaryFileImpl implements PsiFileEx, Queryable, PsiCompiledFile {

    private final Object myMirrorLock = new Object();

    private final boolean myIsForDecompiling;
    private volatile Reference<TreeElement> myMirrorFileElement;

    public USDBinaryFile(@NotNull FileViewProvider viewProvider) {
        this(viewProvider, false);
    }

    public USDBinaryFile(@NotNull FileViewProvider viewProvider, boolean forDecompiling) {
        super((PsiManagerImpl)viewProvider.getManager(), viewProvider);
        myIsForDecompiling = forDecompiling;
    }

    public boolean isValid() {
        return super.isValid() && (myIsForDecompiling || getVirtualFile().isValid());
    }

    @Override
    public void clearCaches() {
    }

    @Override
    public PsiFile getDecompiledPsiFile() {
        System.out.println("getDecompiledPsiFile called");
        return (PsiFile)getMirror();
//            return PsiFileFactory.getInstance(getProject()).createFileFromText(USDLanguage.INSTANCE, asciiContents);
    }

    @Override
    public String getText() {
        VirtualFile file = getVirtualFile();
        Document document = FileDocumentManager.getInstance().getDocument(file);
        assert document != null : file.getUrl();
        return document.getText();
    }

    @NotNull
    @Override
    public Language getLanguage() {
        return USDLanguage.INSTANCE;
    }

    @Override
    public PsiElement getMirror() {
        System.out.println("getMirror called");
        TreeElement mirrorTreeElement = SoftReference.dereference(myMirrorFileElement);
        if (mirrorTreeElement == null) {
            synchronized (myMirrorLock) {
                mirrorTreeElement = SoftReference.dereference(myMirrorFileElement);
                if (mirrorTreeElement == null) {
                    VirtualFile file = getVirtualFile();
                    AstLoadingFilter.assertTreeLoadingAllowed(file);

                    String fileName = file.getName();

                    final Document document = FileDocumentManager.getInstance().getDocument(file);
                    assert document != null : file.getUrl();

                    CharSequence mirrorText = document.getImmutableCharSequence();
//                        CharSequence mirrorText = USDCat.convertToAscii(file);
                    PsiFileFactory factory = PsiFileFactory.getInstance(getManager().getProject());
                    PsiFile mirror = factory.createFileFromText(fileName, USDLanguage.INSTANCE, mirrorText, false, false, true);

                    mirrorTreeElement = SourceTreeToPsiMap.psiToTreeNotNull(mirror);
                    ((PsiFileImpl)mirror).setOriginalFile(this);
                    myMirrorFileElement = new SoftReference<>(mirrorTreeElement);
                }
            }
        }
        return mirrorTreeElement.getPsi();
    }

    public static CharSequence decompile(@NotNull VirtualFile file) {
        PsiManager manager = PsiManager.getInstance(DefaultProjectFactory.getInstance().getDefaultProject());
        final USDBinaryFile binaryFile = new USDBinaryFile(new USDFileViewProvider(manager, file), true);
        final StringBuilder buffer = new StringBuilder();
        ApplicationManager.getApplication().runReadAction(() -> binaryFile.appendMirrorText(buffer));
        return buffer;
    }

    private void appendMirrorText(@NotNull StringBuilder buffer) {
        buffer.append(USDCat.convertToAscii(getVirtualFile()));
    }

}