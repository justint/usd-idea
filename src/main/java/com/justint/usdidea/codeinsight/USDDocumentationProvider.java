package com.justint.usdidea.codeinsight;

import com.intellij.lang.documentation.DocumentationProvider;
import com.intellij.psi.PsiElement;
import com.justint.usdidea.lang.psi.USDFile;
import com.justint.usdidea.lang.psi.usdPrimSpec;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class USDDocumentationProvider implements DocumentationProvider {
    @Nullable
    @Override
    public String getQuickNavigateInfo(PsiElement element, PsiElement originalElement) {
        ArrayList<String> result = new ArrayList<>();

        // Handle layer files
        if (element instanceof USDFile) {
            USDFile usdFile = (USDFile) element;
            result.add("layer file");
            result.add(codedString(usdFile.getVirtualFile().getPath()));
        }
        // Handle USD elements
        else {
            if (element instanceof usdPrimSpec) {
                result.add("prim");

                usdPrimSpec primSpec = (usdPrimSpec)element;
                String primType = primSpec.getPrimType();
                if (primType != null) result.add(primType);

                result.add(codedString(primSpec.getPrimPath()));
            }

            // Include element layer path, if from another layer file
            if (element.getContainingFile() != originalElement.getContainingFile()) {
                result.add("\nin layer file " + element.getContainingFile().getVirtualFile().getPath());
            }
        }

        return String.join(" ", result);
    }

    private static String codedString(String input) {
        return String.format("<code>%s</code>", input);
    }
}
