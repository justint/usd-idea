package com.justint.usdidea.lang.psi.impl;

import com.intellij.icons.AllIcons;
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
            return primNameNode.getText().replaceAll("\\\\ ", " ").replaceAll("\"", "");
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
    public static usdAttributeType getType(usdDictItem dictItemElement) {
        usdDictKey dictKey = dictItemElement.getDictKey();
        return dictKey.getAttributeType();
    }

    @NotNull
    public static String getName(usdMetadatum metadatumElement) {
        usdMetadataKey metadataKey = metadatumElement.getMetadataKey();
        return metadataKey.getText();
    }

    @NotNull
    public static String getName(usdPrimSpec primElement) { return getPrimName(primElement); }
    @NotNull
    public static String getName(usdPropertySpec propertyElement) { return getPropertyName(propertyElement); }

    @NotNull
    public static String getName(usdDictItem dictItemElement) {
        usdDictKey dictKey = dictItemElement.getDictKey();
        usdIdentifier dictIdentifier = dictKey.getIdentifier();
        if (dictIdentifier != null) {
            return dictIdentifier.getText();
        }
        else {
            // The dictionary may have a string name instead, let's check for that
            ASTNode stringName = dictKey.getNode().findChildByType(USDTypes.STRING);
            if (stringName != null) {
                return stringName.getText();
            }
        }
        return "";
    }

    @NotNull
    public static ItemPresentation getPresentation(final usdDictItem dictItemElement) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                String itemName = dictItemElement.getName();
                usdAttributeType itemType = dictItemElement.getType();
                return String.format("%s: %s", itemName, itemType.getText());
            }

            @Nullable
            @Override
            public String getLocationString() {
                if (dictItemElement.isDictionary()) {
                    return null;
                } else return dictItemElement.getDictValue().getText();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean b) {
                if (dictItemElement.isDictionary()) {
                    return AllIcons.Json.Object;
                }
                return PlatformIcons.PROPERTY_ICON;
            }
        };
    }

    @NotNull
    public static ItemPresentation getPresentation(final usdMetadatum metadatumElement) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return metadatumElement.getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                if (metadatumElement.isDictionary()) {
                    return null;
                }
                if (metadatumElement.getMetadataValue() != null) {
                    return metadatumElement.getMetadataValue().getText();
                } else return null;
            }

            @Nullable
            @Override
            public Icon getIcon(boolean b) {
                if (metadatumElement.isDictionary()) {
                    return AllIcons.Json.Object;
                } else return PlatformIcons.METHOD_ICON;
            }
        };
    }

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
                    if (attributeType == null) {
                        return propertyName;
                    }
                    else {
                        String propertyType = attributeType.getText();
                        return String.format("%s: %s", propertyName, propertyType);
                    }
                }
                else if (propertyElement.getPropertyType() == USDTypes.RELATIONSHIP_PROPERTY) {
                    return String.format("%s: variantSet", propertyName);
                }
                else return "";
            }

            @Nullable
            @Override
            public String getLocationString() {
                return null;
            }

            @Nullable
            @Override
            public Icon getIcon(boolean b) {
                return PlatformIcons.PROPERTY_ICON;
            }
        };
    }

    public static boolean isDictionary(usdDictItem dictItemElement) {
        return dictItemElement.getDictValue().getItem().getDict() != null;
    }

    public static boolean isDictionary(usdMetadatum metadatumElement) {
        usdMetadataValue metadataValue = metadatumElement.getMetadataValue();
        if (metadataValue != null) {
            return metadataValue.getItem().getDict() != null;
        }
        return false;
    }
}
