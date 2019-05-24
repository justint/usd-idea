package com.justint.usdidea.codeinsight.highlighting;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.containers.ContainerUtil;
import com.justint.usdidea.lang.lexer.USDHighlighterLexerAdapter;
import com.justint.usdidea.lang.lexer.USDLexerAdapter;
import com.justint.usdidea.lang.parser.USDParserDefinition;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;


public class USDSyntaxHighlighter extends SyntaxHighlighterBase {

    // TextAttributesKey instances
    public static final TextAttributesKey USDDECLARATION =
            createTextAttributesKey("USDDECLARATION", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);

    private static final Map<IElementType, TextAttributesKey> ATTRIBUTES = ContainerUtil.newHashMap();

    static {
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.USDDECLARATION, DefaultLanguageHighlighterColors.CONSTANT);
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.BRACKETS, DefaultLanguageHighlighterColors.BRACKETS);
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.KEYWORDS, DefaultLanguageHighlighterColors.KEYWORD);
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.SPECIAL_KEYWORDS, DefaultLanguageHighlighterColors.STATIC_FIELD);
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.STRINGS, DefaultLanguageHighlighterColors.STRING);
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.NUMBERS, DefaultLanguageHighlighterColors.NUMBER);
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.LINE_COMMENTS, DefaultLanguageHighlighterColors.LINE_COMMENT);
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.BLOCK_COMMENTS, DefaultLanguageHighlighterColors.BLOCK_COMMENT);
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.IDENTIFIERS, DefaultLanguageHighlighterColors.IDENTIFIER);
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.PRIM_NAMES, DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.ASSETREFERENCES, USDHighlighterColors.ASSETREFERENCE_KEY);
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.PATHREFERENCES, USDHighlighterColors.PATHREFERENCE_KEY);
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.METADATA_KEYS, DefaultLanguageHighlighterColors.INSTANCE_FIELD);
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new USDHighlighterLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack(ATTRIBUTES.get(tokenType));
    }

}
