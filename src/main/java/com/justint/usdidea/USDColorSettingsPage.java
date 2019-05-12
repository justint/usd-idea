package com.justint.usdidea;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class USDColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[] {
            new AttributesDescriptor("Number", USDSyntaxHighlighter.NUMBER),
            new AttributesDescriptor("String", USDSyntaxHighlighter.STRING),
            new AttributesDescriptor("Comment", USDSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("USD Declaration", USDSyntaxHighlighter.USDDECLARATION)
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return USDIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new USDSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        // TODO: replace with custom demo text
        return "#usda 1.0\n" +
                "\n" +
                "(\n" +
                "    upAxis = \"Y\"\n" +
                "    doc = \"\"\"This layer represents the various geometric forms that curves\n" +
                "             may be used to represent.\"\"\"\n" +
                ")\n" +
                "\n" +
                "\n" +
                "def Xform \"Linear\" {\n" +
                "    uniform token[] xformOpOrder = [\"xformOp:translate\"]\n" +
                "    float3 xformOp:translate = (0, 9, 0)\n" +
                "    def Scope \"Tubes\"{\n" +
                "        def BasisCurves \"ConstantWidth\" (){\n" +
                "            uniform token[] xformOpOrder = [\"xformOp:translate\"]\n" +
                "            float3 xformOp:translate = (3, 0, 0)\n" +
                "\n" +
                "            uniform token type = \"linear\"\n" +
                "            int[] curveVertexCounts = [7]\n" +
                "            point3f[] points = [(0, 0, 0), (1, 1, 0), (1, 2, 0), (0, 3, 0), (-1, 4, 0), (-1, 5, 0), (0, 6, 0)]\n" +
                "            float[] widths = [.5] (interpolation = \"constant\")\n" +
                "            color3f[] primvars:displayColor = [(1, 0, 0)]\n" +
                "        }\n" +
                "        def BasisCurves \"VaryingWidth\" (){\n" +
                "            uniform token[] xformOpOrder = [\"xformOp:translate\"]\n" +
                "            float3 xformOp:translate = (6, 0, 0)\n" +
                "\n" +
                "            uniform token type = \"linear\"\n" +
                "            int[] curveVertexCounts = [7]\n" +
                "            point3f[] points = [(0, 0, 0), (1, 1, 0), (1, 2, 0), (0, 3, 0), (-1, 4, 0), (-1, 5, 0), (0, 6, 0)]\n" +
                "            float[] widths = [0, .5, .5, .8, .5, .5, 0] (interpolation = \"varying\")\n" +
                "            color3f[] primvars:displayColor = [(0, 0, 1)]\n" +
                "        }\n" +
                "    }\n" +
                "    def Scope \"Ribbons\"{\n" +
                "        def BasisCurves \"VaryingWidth\" (){\n" +
                "            uniform token[] xformOpOrder = [\"xformOp:translate\"]\n" +
                "            float3 xformOp:translate = (12, 0, 0)\n" +
                "\n" +
                "            uniform token type = \"linear\"\n" +
                "            int[] curveVertexCounts = [7]\n" +
                "            point3f[] points = [(0, 0, 0), (1, 1, 0), (1, 2, 0), (0, 3, 0), (-1, 4, 0), (-1, 5, 0), (0, 6, 0)]\n" +
                "            float[] widths = [0, .5, .5, .8, .5, .5, 0] (interpolation = \"varying\")\n" +
                "            normal3f[] normals = [(1, 0, 0), (.98, 0, .44), (.98, 0, .44), (.707, 0, .707), (.98, 0, .44), (.98, 0, .44), (1, 0, 0)] (interpolation = \"varying\")\n" +
                "            color3f[] primvars:displayColor = [(0, 1, 0)]\n" +
                "        }\n" +
                "        def BasisCurves \"ConstantWidth\" (){\n" +
                "            uniform token[] xformOpOrder = [\"xformOp:translate\"]\n" +
                "            float3 xformOp:translate = (15, 0, 0)\n" +
                "\n" +
                "            uniform token type = \"linear\"\n" +
                "            int[] curveVertexCounts = [7]\n" +
                "            point3f[] points = [(0, 0, 0), (1, 1, 0), (1, 2, 0), (0, 3, 0), (-1, 4, 0), (-1, 5, 0), (0, 6, 0)]\n" +
                "            float[] widths = [.5] (interpolation = \"constant\")\n" +
                "            normal3f[] normals = [(1, 0, 0), (.98, 0, .44), (.98, 0, .44), (.707, 0, .707), (.98, 0, .44), (.98, 0, .44), (1, 0, 0)] (interpolation = \"varying\")\n" +
                "            color3f[] primvars:displayColor = [(1, 1, 1)]\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "USD";
    }
}
