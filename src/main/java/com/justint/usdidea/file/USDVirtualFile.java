package com.justint.usdidea.file;

import com.intellij.execution.ExecutionException;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileSystem;
import com.intellij.testFramework.LightVirtualFile;
import com.justint.usdidea.lang.USDLanguage;
import com.justint.usdidea.util.USDFormat;
import com.justint.usdidea.util.binscripts.USDCat;
import org.jetbrains.annotations.NotNull;

public class USDVirtualFile extends LightVirtualFile {

    private final Project project;

    private USDFormat format;

    private CharSequence convertedContent;

    public USDVirtualFile(VirtualFile virtualFile, Project project) {

        this.project = project;

        this.setOriginalFile(virtualFile);
        this.setModificationStamp(virtualFile.getModificationStamp());

        this.format = virtualFile.isCharsetSet() ? USDFormat.USDA : USDFormat.USDC;
    }

    @Override
    public Language getLanguage() {
        return USDLanguage.INSTANCE;
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return USDFileType.INSTANCE;
    }

    @NotNull
    @Override
    public VirtualFileSystem getFileSystem() {
        return USDVirtualFileSystem.getInstance();
    }

    @NotNull
    @Override
    public String getPath() {
        return getOriginalFile().getPath();
    }

    private CharSequence initializeConvertedContents() {
        System.out.println("initializeConvertedContents: " + getOriginalFile().getName());
        CharSequence output = "";

        try {
            USDCat usdcat = new USDCat(getOriginalFile().getPath(), project);
            output = usdcat.readFileContents();
            USDVirtualFile.this.setValid(true);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            USDVirtualFile.this.setValid(false);
        }
        return output;
    }

    @NotNull
    @Override
    public byte[] contentsToByteArray() {
//        System.out.println("contentsToByteArray: " + this.getName());
//        System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));

        if (convertedContent == null) {
            convertedContent = initializeConvertedContents();
        }

        String contentString = convertedContent.toString();
        return contentString.getBytes();
    }

    @NotNull
    @Override
    public CharSequence getContent() {
        if (convertedContent == null) {
            convertedContent = initializeConvertedContents();
        }

        return convertedContent;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof VirtualFile) {
//            return ((VirtualFile) obj).getPath().equals(getPath());
//        } else return super.equals(obj);
//    }
}
