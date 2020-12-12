package com.justint.usdidea.codeinsight.folding;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilder;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.lang.folding.NamedFoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.psi.tree.IElementType;
import com.justint.usdidea.lang.psi.USDTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class USDFoldingBuilder implements FoldingBuilder {

    private static final IElementType[] BRACKET_TYPES = new IElementType[] {
            USDTypes.BODY,
            USDTypes.DICT,
            USDTypes.TIME_SAMPLE
    };

    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(@NotNull ASTNode astNode, @NotNull Document document) {
        List<FoldingDescriptor> descriptors = new ArrayList<>();
        collectRegionsRecursively(astNode, document, descriptors);
        return descriptors.toArray(FoldingDescriptor.EMPTY);
    }

    private void collectRegionsRecursively(@NotNull final ASTNode astNode,
                                           @NotNull final Document document,
                                           @NotNull List<FoldingDescriptor> descriptors) {
        final IElementType elementType = astNode.getElementType();

        if (elementType == USDTypes.METADATA) {
            descriptors.add(new FoldingDescriptor(
                    astNode,
                    astNode.getTextRange(),
                    null,
                    "(...)"
            ));
        } else if (Arrays.asList(BRACKET_TYPES).contains(elementType)) {
            descriptors.add(new FoldingDescriptor(
                    astNode,
                    astNode.getTextRange(),
                    null,
                    "{...}"));
        }

        for (ASTNode child : astNode.getChildren(null)) {
            collectRegionsRecursively(child, document, descriptors);
        }
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode astNode) {
        return "...";
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode astNode) {
        return false;
    }
}
