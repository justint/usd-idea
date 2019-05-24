package com.justint.usdidea.lang.parser;

import com.intellij.lang.*;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.justint.usdidea.lang.USDLanguage;
import com.justint.usdidea.lang.lexer.USDLexerAdapter;
import com.justint.usdidea.lang.psi.*;
import org.jetbrains.annotations.NotNull;

public class USDParserDefinition implements ParserDefinition {
    public static final TokenSet USDDECLARATION = TokenSet.create(USDTypes.USDDECLARATION);

    public static final TokenSet ASSETREFERENCES = TokenSet.create(USDTypes.ASSETREFERENCE);

    public static final TokenSet PATHREFERENCES = TokenSet.create(USDTypes.PATHREFERENCE);

    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);

    public static final TokenSet LINE_COMMENTS = TokenSet.create(USDTypes.COMMENT);

    public static final TokenSet BLOCK_COMMENTS = TokenSet.create(USDTypes.BLOCKCOMMENT);

    public static final TokenSet STRINGS = TokenSet.create(USDTypes.STRING);

    public static final TokenSet NUMBERS = TokenSet.create(
            USDTypes.NUMBER,
            USDTypes.FLOATNUMBER
    );

    public static final TokenSet BRACKETS = TokenSet.create(
            USDTypes.LEFTBRACE, USDTypes.RIGHTBRACE,
            USDTypes.LEFTBRACKET, USDTypes.RIGHTBRACKET,
            USDTypes.LEFTPARENS, USDTypes.RIGHTPARENS
    );

    public static final TokenSet IDENTIFIERS = TokenSet.create(USDTypes.IDENTIFIER);

    public static final TokenSet PRIM_NAMES = TokenSet.create(USDTypes.PRIM_NAME);

    public static final TokenSet SPECIAL_KEYWORDS = TokenSet.create(
            USDTypes.DOC,
            USDTypes.INHERITS,
            USDTypes.KIND,
            USDTypes.PAYLOAD,
            USDTypes.REFERENCES,
            USDTypes.SUBLAYERS,
            USDTypes.SPECIALIZES,
            USDTypes.VARIANTSETS,
            USDTypes.VARIANTS
    );

    public static final TokenSet METADATA_KEYS = TokenSet.create(USDTypes.METADATA_KEY);

    public static final TokenSet KEYWORDS = TokenSet.create(
            USDTypes.ADD,
            USDTypes.APPEND,
            USDTypes.ATTRIBUTES,
            USDTypes.CLASS,
            USDTypes.CONFIG,
            USDTypes.CONNECT,
            USDTypes.CUSTOM,
            USDTypes.CUSTOMDATA,
            USDTypes.DEFAULT,
            USDTypes.DEF,
            USDTypes.DELETE,
            USDTypes.DICTIONARY,
            USDTypes.DISPLAYUNIT,
            USDTypes.MAPPER,
            USDTypes.NAMECHILDREN,
            USDTypes.NONE,
            USDTypes.OFFSET,
            USDTypes.OVER,
            USDTypes.PERMISSION,
            USDTypes.PREFIXSUBSTITUTIONS,
            USDTypes.PREPEND,
            USDTypes.PROPERTIES,
            USDTypes.RELOCATES,
            USDTypes.REL,
            USDTypes.REORDER,
            USDTypes.ROOTPRIMS,
            USDTypes.SUFFIXSUBSTITUTIONS,
            USDTypes.SYMMETRYARGUMENTS,
            USDTypes.SYMMETRYFUNCTION,
            USDTypes.UNIFORM,
            USDTypes.VARIANTSET,
            USDTypes.VARYING
    );

    public static final IFileElementType FILE = new IFileElementType(USDLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new USDLexerAdapter();
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return LINE_COMMENTS;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    public PsiParser createParser(final Project project) {
        return new USDParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    public PsiFile createFile(FileViewProvider viewProvider) {
        return new USDFile(viewProvider);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    public PsiElement createElement(ASTNode node) {
        return USDTypes.Factory.createElement(node);
    }

}
