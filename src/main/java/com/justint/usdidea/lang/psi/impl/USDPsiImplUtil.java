package com.justint.usdidea.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.PlatformIcons;
import com.justint.usdidea.lang.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class USDPsiImplUtil {
    @NotNull
    public static String getPrimName(@NotNull usdPrimSpec primElement) {
        ASTNode specifierNode = primElement.getNode().findChildByType(USDTypes.SPECIFIER);
        assert specifierNode != null;
        ASTNode primNameNode = specifierNode.findChildByType(USDTypes.PRIM_NAME).findChildByType(USDTypes.STRING);
        if (primNameNode != null) {
            return primNameNode.getText().replaceAll("\\\\ ", " ");
        } else return "";
    }

    @Nullable
    public static String getPrimType(@NotNull usdPrimSpec primElement) {
        ASTNode primTypeNode = primElement.getNode().findChildByType(USDTypes.ALPHA);
        if (primTypeNode != null) {
            return primTypeNode.getText();
        } else return null;
    }

    @NotNull
    public static String getPropertyName(@NotNull usdPropertySpec propertyElement) {
        IElementType propertyType = getPropertyType(propertyElement);
        if (propertyType == USDTypes.ATTRIBUTE_PROPERTY) {
            ASTNode attributeProperty = propertyElement.getNode().findChildByType(USDTypes.ATTRIBUTE_PROPERTY);
            assert attributeProperty != null;
            ASTNode attributeName = attributeProperty.findChildByType(USDTypes.ATTRIBUTE_NAME);
            if (attributeName != null) {
                return attributeName.getText();
            }
        } else if (propertyType == USDTypes.RELATIONSHIP_PROPERTY) {
            ASTNode relationshipProperty = propertyElement.getNode().findChildByType(USDTypes.RELATIONSHIP_PROPERTY);
            assert relationshipProperty != null;
            ASTNode relationshipName = relationshipProperty.findChildByType(USDTypes.STRING);
            if (relationshipName != null) {
                return relationshipName.getText();
            }
        }
        return "";
    }

    @Nullable
    public static IElementType getPropertyType(usdPropertySpec propertyElement) {
        if (propertyElement.getNode().findChildByType(USDTypes.ATTRIBUTE_PROPERTY) != null) {
            return USDTypes.ATTRIBUTE_PROPERTY;
        } else if (propertyElement.getNode().findChildByType(USDTypes.RELATIONSHIP_PROPERTY) != null) {
            return USDTypes.RELATIONSHIP_PROPERTY;
        } else return null;
    }

    @NotNull
    public static String getName(usdPrimSpec primElement) { return getPrimName(primElement); }
    @NotNull
    public static String getName(usdPropertySpec propertyElement) { return getPropertyName(propertyElement); }

    @NotNull
    public static ItemPresentation getPresentation(final usdPrimSpec primElement) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                String primName = primElement.getName();

                usdSpecifier specifier = primElement.getSpecifier();
                usdTypename typename = specifier.getTypename();
                if (typename != null) {
                    return String.format("%s: %s", primName, typename.getText());
                } else {
                    return primName;
                }
            }

            @Nullable
            @Override
            public String getLocationString() {
//                PsiFile containingFile = primElement.getContainingFile();
//                return containingFile == null ? null : containingFile.getName();
                // It looks cleaner without the containing file, for now
                return null;
            }

            @Nullable
            @Override
            public Icon getIcon(boolean b) {
                return PlatformIcons.PARAMETER_ICON;
            }
        };
    }
    @NotNull
    public static ItemPresentation getPresentation(final usdPropertySpec propertyElement) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                String propertyName = propertyElement.getName();

                if (propertyElement.getPropertyType() == USDTypes.ATTRIBUTE_PROPERTY) {
                    usdAttributeProperty attributeProperty = propertyElement.getAttributeProperty();
                    assert attributeProperty != null;
                    usdAttributeType attributeType = attributeProperty.getAttributeType();
                    assert attributeType != null;
                    String propertyType = attributeType.getText();
                    return String.format("%s: %s", propertyName, propertyType);
                }
                else if (propertyElement.getPropertyType() == USDTypes.RELATIONSHIP_PROPERTY) {
                    return propertyName;
                }
                else return "";
            }

            @Nullable
            @Override
            public String getLocationString() {
//                PsiFile containingFile = propertyElement.getContainingFile();
//                return containingFile == null ? null : containingFile.getName();
                // It looks cleaner without the containing file, for now
                return null;
            }

            @Nullable
            @Override
            public Icon getIcon(boolean b) {
                return PlatformIcons.PROPERTY_ICON;
            }
        };
    }
}
