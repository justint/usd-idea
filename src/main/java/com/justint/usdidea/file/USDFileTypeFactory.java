package com.justint.usdidea.file;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class USDFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(USDFileType.INSTANCE, "usd");
        fileTypeConsumer.consume(USDAFileType.INSTANCE, "usda");
    }
}
