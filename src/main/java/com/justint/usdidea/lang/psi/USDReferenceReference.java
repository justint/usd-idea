package com.justint.usdidea.lang.psi;

import com.intellij.execution.ExecutionException;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiReferenceBase;
import com.justint.usdidea.lang.psi.impl.USDPsiImplUtil;
import com.justint.usdidea.util.binscripts.USDResolve;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class USDReferenceReference extends PsiReferenceBase<PsiElement> {
    public USDReferenceReference(@NotNull PsiElement element, TextRange rangeInElement) {
        super(element, rangeInElement);
    }

    @Nullable
    private PsiFile getResolvedReferenceAssetFile(String referenceLayerPath, File sourceElementFile) {
        USDResolve resolver = new USDResolve(referenceLayerPath, sourceElementFile.getParent(), myElement.getProject());
        boolean resolverIsValid = resolver.isUSDInstallValid();

        String targetLayerPath = null;

        // Attempt to resolve this path as a literal filesystem path first
        try {
            File targetLayerFile = new File(Paths.get(sourceElementFile.getParent(), referenceLayerPath).toString());
            targetLayerPath = targetLayerFile.getAbsolutePath();
        }
        catch (InvalidPathException e) {
            // It may be a custom URL path; we'll try the resolver next if possible
        }
        if (resolverIsValid) {
            try {
                // Attempt to derive this path from `usdresolve`, if possible
                targetLayerPath = resolver.resolvePath();
            } catch (ExecutionException | InterruptedException e) {
                // Resolver failed/was interrupted
                return null;
            }
        }

        if (targetLayerPath == null) return null;

        VirtualFile layerVf = VirtualFileManager.getInstance().findFileByUrl("file://" + targetLayerPath);
        if (layerVf == null) return null;

        return PsiManager.getInstance(myElement.getProject()).findFile(layerVf);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        PsiFile resolvedAssetFile = myElement.getContainingFile();
        String referencePath = myElement.getText();

        boolean hasAssetPath = false;
        boolean hasPrimPath = false;

        if (referencePath.contains("@")) {
            hasAssetPath = true;
        }
        if (referencePath.contains("<")) {
            hasPrimPath = true;
        }

        if (!hasAssetPath && !hasPrimPath) {
            return null;
        }
        if (hasAssetPath) {
            String assetPath = referencePath.split("@")[1];

            String sourceElementFilePath = myElement.getContainingFile().getVirtualFile().getPath();
            File sourceElementFile = new File(sourceElementFilePath);

            resolvedAssetFile = getResolvedReferenceAssetFile(assetPath, sourceElementFile);
            if (resolvedAssetFile == null) return null;
        }
        if (hasPrimPath) {
            if (resolvedAssetFile instanceof USDFile) {
                String primPath = referencePath.split("<")[1].replace(">", "");
                PsiElement foundPrim = USDPsiImplUtil.findPrimInLayerFromPath((USDFile)resolvedAssetFile, primPath);
                if (foundPrim != null) return foundPrim;
                else return null;
            }
            else {
                // We have a prim path pointing into a non-USD layer asset file... strange, we'll just return no result
                return null;
            }
        }
        else {
            return resolvedAssetFile;
        }
    }
}
