package com.justint.usdidea.codeinsight.highlighting;

import com.intellij.openapi.editor.colors.TextAttributesKey;

import static com.intellij.openapi.editor.colors.CodeInsightColors.HYPERLINK_ATTRIBUTES;

public class USDHighlighterColors {
    public static final TextAttributesKey ASSETREFERENCE_KEY = TextAttributesKey.createTextAttributesKey("ASSETREFERENCE", HYPERLINK_ATTRIBUTES);
    public static final TextAttributesKey PATHREFERENCE_KEY = TextAttributesKey.createTextAttributesKey("PATHREFERENCE", HYPERLINK_ATTRIBUTES);
}
