package com.justint.usdidea.file;

import com.intellij.openapi.fileTypes.BinaryFileDecompiler;
import com.intellij.openapi.vfs.VirtualFile;
import com.justint.usdidea.util.USDCat;
import org.jetbrains.annotations.NotNull;

public class USDFileDecompiler implements BinaryFileDecompiler {

    @NotNull
    @Override
    public CharSequence decompile(@NotNull VirtualFile file) {
        return USDBinaryFile.decompile(file);
    }
}
