package com.justint.usdidea.file;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.ex.dummy.DummyFileSystem;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class USDVirtualFileSystem extends DummyFileSystem {

    private static final String PROTOCOL = "usd";
    private static final String[] EXTENSIONS = {"usd", "usdc"};
    private static final USDVirtualFileSystem INSTANCE = new USDVirtualFileSystem();

    private ArrayList<USDVirtualFile> usdVirtualFileArrayList;

    public USDVirtualFileSystem() {
        usdVirtualFileArrayList = new ArrayList<>();
    }


    public static USDVirtualFileSystem getInstance() {
        return INSTANCE;
    }

    public USDVirtualFile findUSDVirtualFile(VirtualFile virtualFile, Project project) {
        List<USDVirtualFile> usdVirtualFiles = usdVirtualFileArrayList
                .stream()
                .filter((file) -> file.getPath().equals(virtualFile.getPath()))
                .collect(Collectors.toList());

        USDVirtualFile foundUSDVirtualFile = null;
        if (usdVirtualFiles.size() == 1) {
            foundUSDVirtualFile = usdVirtualFiles.get(0);
        }
        else if (usdVirtualFiles.size() == 0) {
            foundUSDVirtualFile = new USDVirtualFile(virtualFile, project);
            usdVirtualFileArrayList.add(foundUSDVirtualFile);
        }
        return foundUSDVirtualFile;
    }

    @Override
    public VirtualFile findFileByPath(@NotNull String path) {
        USDVirtualFile usdVirtualFile;
        VirtualFile virtualFile = super.findFileByPath(path);
        if (virtualFile == null) {
            return null;
        }
        if (Arrays.stream(EXTENSIONS).anyMatch(s -> s.equals(virtualFile.getExtension()))) {
            usdVirtualFile = (USDVirtualFile) virtualFile;
            return usdVirtualFile;
        } else {
            return virtualFile;
        }

    }

    @NotNull
    @Override
    public String getProtocol() {
        return PROTOCOL;
    }
}
