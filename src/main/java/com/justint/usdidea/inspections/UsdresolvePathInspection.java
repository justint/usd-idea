package com.justint.usdidea.inspections;

import com.intellij.codeInspection.*;
import com.intellij.openapi.options.ShowSettingsUtil;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.justint.usdidea.lang.psi.usdReferenceItem;
import com.justint.usdidea.settings.USDSettingsConfigurable;
import com.justint.usdidea.settings.USDSettingsState;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class UsdresolvePathInspection extends LocalInspectionTool {

    @NotNull
    @Override
    public PsiElementVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly, @NotNull LocalInspectionToolSession session) {
        // Don't bother the user if they've already configured usdresolve
        if (USDSettingsState.getInstance().isUsdresolvePathValid()) return PsiElementVisitor.EMPTY_VISITOR;
        else return new PsiElementVisitor() {

            @Override
            public void visitElement(@NotNull PsiElement element) {
                if (element instanceof usdReferenceItem) {
                    usdReferenceItem referenceItem = (usdReferenceItem)element;
                    PsiElement assetReference = referenceItem.getAssetReference();
                    if (assetReference != null) {
                        String assetPathString = assetReference.getText().split("@")[1];
                        File assetFile = new File(assetPathString);
                        if (!isFileRelative(assetPathString) && !assetFile.exists()) {
                            String description = "Cannot resolve asset reference '" + assetReference.getText() + "' without configuration of usdresolve install path";
                            holder.registerProblem(
                                    element,
                                    description,
                                    ProblemHighlightType.WEAK_WARNING,
                                    new OpenUSDSettingsQuickFix());
                        }
                    }
                }
            }
        };
    }

    private boolean isFileRelative(@NotNull String assetPathString) {
        return assetPathString.contains("./") || assetPathString.contains("../");
    }


    private static class OpenUSDSettingsQuickFix implements LocalQuickFix {
        @NotNull
        @Override
        public String getFamilyName() {
            return "Configure usdresolve path";
        }

        @Override
        public boolean startInWriteAction() {
            return false;
        }

        @Override
        public void applyFix(@NotNull Project project, @NotNull ProblemDescriptor problemDescriptor) {
            showUSDSettingsDialog(project);
        }

        public static void showUSDSettingsDialog(@NotNull Project project) {
            ShowSettingsUtil.getInstance().showSettingsDialog(project, USDSettingsConfigurable.class);
        }
    }
}
