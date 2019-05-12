package com.justint.usdidea;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.containers.ContainerUtil;
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

//
//    // TextAttributesKey arrays
//    private static final TextAttributesKey[] CONSTANTS = new TextAttributesKey[] {USD_DECLARATION};
//    private static final TextAttributesKey[] IDENTIFIERS = new TextAttributesKey[]{
//            createTextAttributesKey("ALPHA", DefaultLanguageHighlighterColors.IDENTIFIER)
//    };
//    private static final TextAttributesKey[] INSTANCE_FIELDS = new TextAttributesKey[]{
//            createTextAttributesKey("ATTRIBUTE_NAME", DefaultLanguageHighlighterColors.INSTANCE_FIELD),
//            createTextAttributesKey("PRIM_NAME", DefaultLanguageHighlighterColors.INSTANCE_FIELD)
//    };
//    private static final TextAttributesKey[] KEYWORDS = new TextAttributesKey[]{
//            createTextAttributesKey("ADD", DefaultLanguageHighlighterColors.KEYWORD),
//            createTextAttributesKey("ALPHA", DefaultLanguageHighlighterColors.KEYWORD),
//            createTextAttributesKey("APPEND", DefaultLanguageHighlighterColors.KEYWORD),
//            createTextAttributesKey("CLASS", DefaultLanguageHighlighterColors.KEYWORD),
//            createTextAttributesKey("DEF", DefaultLanguageHighlighterColors.KEYWORD),
//            createTextAttributesKey("DELETE", DefaultLanguageHighlighterColors.KEYWORD),
//            createTextAttributesKey("OVER", DefaultLanguageHighlighterColors.KEYWORD),
//            createTextAttributesKey("PREPEND", DefaultLanguageHighlighterColors.KEYWORD),
//
//    };
//    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
//    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
//    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
//
//    private static final IElementType[] USD_KEYWORDS = {
//            USDTypes.ADD,
//            USDTypes.ALPHA,
//            USDTypes.APPEND,
//            USDTypes.CLASS,
//            USDTypes.DEF,
//            USDTypes.DELETE,
//            USDTypes.OVER,
//            USDTypes.PREPEND
//    };

    private static final Map<IElementType, TextAttributesKey> ATTRIBUTES = ContainerUtil.newHashMap();

    static {
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.USDDECLARATION, DefaultLanguageHighlighterColors.CONSTANT);
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.BRACKETS, DefaultLanguageHighlighterColors.BRACKETS);
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.KEYWORDS, DefaultLanguageHighlighterColors.KEYWORD);
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.STRINGS, DefaultLanguageHighlighterColors.STRING);
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.NUMBERS, DefaultLanguageHighlighterColors.NUMBER);
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.LINE_COMMENTS, DefaultLanguageHighlighterColors.LINE_COMMENT);
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.BLOCK_COMMENTS, DefaultLanguageHighlighterColors.BLOCK_COMMENT);
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.IDENTIFIERS, DefaultLanguageHighlighterColors.IDENTIFIER);
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.ASSETREFERENCES, USDHighlighterColors.ASSETREFERENCE_KEY);
        SyntaxHighlighterBase.fillMap(ATTRIBUTES, USDParserDefinition.PATHREFERENCES, USDHighlighterColors.PATHREFERENCE_KEY);
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new USDLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack(ATTRIBUTES.get(tokenType));
    }

}
