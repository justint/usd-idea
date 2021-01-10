package com.justint.usdidea.lang.psi.impl;

import com.intellij.icons.AllIcons;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.ui.LayeredIcon;
import com.intellij.util.PlatformIcons;
import com.justint.usdidea.lang.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class USDPsiImplUtil {

    private static String trimStringNames(String name) {
        return name.replaceAll("\\\\ ", " ").replaceAll("\"", "");
    }

    @NotNull
    public static String getPrimName(@NotNull usdPrimSpec primElement) {
        ASTNode specifierNode = primElement.getNode().findChildByType(USDTypes.SPECIFIER);
        assert specifierNode != null;
        ASTNode primNameNode = specifierNode.findChildByType(USDTypes.PRIM_NAME).findChildByType(USDTypes.STRING);
        if (primNameNode != null) {
            return trimStringNames(primNameNode.getText());
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
            } else {
                // The attribute property might be a composition arc; let's try finding it
                ASTNode compositionArcName = attributeProperty.findChildByType(USDTypes.COMPOSITION_ARC);
                if (compositionArcName != null) {
                    return compositionArcName.getText();
                }
            }
        } else if (propertyType == USDTypes.RELATIONSHIP_PROPERTY) {
            ASTNode relationshipProperty = propertyElement.getNode().findChildByType(USDTypes.RELATIONSHIP_PROPERTY);
            assert relationshipProperty != null;
            ASTNode relationshipName = relationshipProperty.findChildByType(USDTypes.STRING);
            if (relationshipName != null) {
                return trimStringNames(relationshipName.getText());
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

    public static usdVariantSetItemBody getBody(usdVariantSetKey variantSetKey) {
        return PsiTreeUtil.getNextSiblingOfType(variantSetKey, usdVariantSetItemBody.class);
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

    public static String getName(usdVariantSetKey variantSetKey) {
        return trimStringNames(variantSetKey.getString().getText());
    }

    public static String getName(usdReferenceItem referenceItem) {
        return referenceItem.getText();
    }

    public static PsiElement setName(usdReferenceItem referenceItem, String newName) {
        // TODO: figure this out...
        return referenceItem;
    }

    public static PsiElement getNameIdentifier(usdReferenceItem referenceItem) {
        return referenceItem.getNode().getPsi();
    }

    @NotNull
    public static ItemPresentation getPresentation(final usdDictItem dictItemElement) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return dictItemElement.getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                if (dictItemElement.isDictionary()) {
                    return null;
                } else {
                    return dictItemElement.getType().getText();
                }
            }

            @Nullable
            @Override
            public Icon getIcon(boolean b) {
                if (dictItemElement.isDictionary()) {
                    return LayeredIcon.create(AllIcons.Json.Object, AllIcons.Nodes.StaticMark);
                }
                return LayeredIcon.create(PlatformIcons.PROPERTY_ICON, AllIcons.Nodes.StaticMark);
            }
        };
    }

    @NotNull
    public static ItemPresentation getPresentation(final usdMetadatum metadatumElement) {
        return new ItemPresentation() {

            // This works, but isn't neccessary - I think we can stick with layered/row icons for now
//            public TextAttributesKey getTextAttributesKey() {
//                TextAttributes attributes = DefaultLanguageHighlighterColors.IDENTIFIER.getDefaultAttributes().clone();
//                attributes.setFontType(Font.ITALIC);
//                return TextAttributesKey.createTextAttributesKey("USD_METADATA_KEY", attributes);
//            }

            @Nullable
            @Override
            public String getPresentableText() {
                return metadatumElement.getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                return null;
            }

            @Nullable
            @Override
            public Icon getIcon(boolean b) {
                if (metadatumElement.isDictionary()) {
                    // IconWithToolTip isn't available pre-idea v202 :((((
                    // see: https://github.com/JetBrains/intellij-community/commits/6d7de87eb240af675327767fb6414cbd1d838a93/platform/core-ui/src/ui/IconWithToolTip.java
                    // TODO: figure out how to support both tooltips + nontooltips
                    return LayeredIcon.create(AllIcons.Json.Object, AllIcons.Nodes.StaticMark);
                } else return LayeredIcon.create(PlatformIcons.METHOD_ICON, AllIcons.Nodes.StaticMark);
            }
        };
    }

    @NotNull
    public static ItemPresentation getPresentation(final usdPrimSpec primElement) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return primElement.getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                usdSpecifier specifier = primElement.getSpecifier();
                usdTypename typename = specifier.getTypename();
                if (typename != null) {
                    return String.format("prim : %s", typename.getText());
                } else return "prim";
            }

            @Nullable
            @Override
            public Icon getIcon(boolean b) {
                usdSpecifier specifier = primElement.getSpecifier();
                if (specifier.getText().split("\\s+")[0].equals("class")) {
                    // It's a class, not a prim
                    return PlatformIcons.CLASS_ICON;
                }
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
                return propertyElement.getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                if (propertyElement.getPropertyType() == USDTypes.ATTRIBUTE_PROPERTY) {
                    usdAttributeProperty attributeProperty = propertyElement.getAttributeProperty();
                    assert attributeProperty != null;
                    usdAttributeType attributeType = attributeProperty.getAttributeType();
                    if (attributeType != null) {
                        return attributeType.getText();
                    }
                }
                else if (propertyElement.getPropertyType() == USDTypes.RELATIONSHIP_PROPERTY) {
                    return "variantSet";
                }
                return null;
            }

            @Nullable
            @Override
            public Icon getIcon(boolean b) {
                if (propertyElement.getPropertyType() == USDTypes.ATTRIBUTE_PROPERTY) {
                    return PlatformIcons.PROPERTY_ICON;
                }
                else {
                    // It's a relationship property (which as of now, we're using to represent variantSets)
                    // TODO: find/create better icon for variant sets
                    return PlatformIcons.VARIABLE_ICON;
                }
            }
        };
    }

    public static ItemPresentation getPresentation(usdVariantSetKey variantSetKey) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return variantSetKey.getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                return "variant";
            }

            @Nullable
            @Override
            public Icon getIcon(boolean b) {
                return PlatformIcons.VARIABLE_ICON;
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

    @Nullable
    public static PsiElement findPrimInLayerFromPath(USDFile layer, String path) {
        ArrayList<String> prims = new ArrayList<>(Arrays.asList(path.split("/")));
        if (prims.size() == 0) {
            // The path is pointing to the pseudoroot; return the layer file PsiElement itself
            return layer;
        }
        prims.remove(0); // The pseudoroot ("") is never needed, since local layer reference paths always start with a '/'

        boolean found = false;
        PsiElement currentPrimPsiElement = layer;
        for (int i = 0; i < prims.size(); i++) {
            String currentPrim = prims.get(i);

            List<usdPrimSpec> children;
            if (currentPrimPsiElement instanceof usdPrimSpec) {
                children = PsiTreeUtil.getChildrenOfTypeAsList(((usdPrimSpec) currentPrimPsiElement).getBody(), usdPrimSpec.class);
            } else {
                children = PsiTreeUtil.getChildrenOfTypeAsList(currentPrimPsiElement, usdPrimSpec.class);
            }
            for (usdPrimSpec child : children) {
                if (child.getPrimName().equals(currentPrim)) {
                    currentPrimPsiElement = child;
                    if (i + 1 == prims.size()) {
                        found = true;
                    }
                }
            }
        }
        if (found) {
            return currentPrimPsiElement;
        } else return null;
    }
}
