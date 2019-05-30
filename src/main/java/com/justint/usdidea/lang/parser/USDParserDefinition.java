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
            USDTypes.DOC,
            USDTypes.FALSE,
            USDTypes.INHERITS,
            USDTypes.KIND,
            USDTypes.MAPPER,
            USDTypes.NAMECHILDREN,
            USDTypes.NONE,
            USDTypes.OFFSET,
            USDTypes.OVER,
            USDTypes.PAYLOAD,
            USDTypes.PERMISSION,
            USDTypes.PREFIXSUBSTITUTIONS,
            USDTypes.PREPEND,
            USDTypes.PROPERTIES,
            USDTypes.REFERENCES,
            USDTypes.RELOCATES,
            USDTypes.REL,
            USDTypes.REORDER,
            USDTypes.ROOTPRIMS,
            USDTypes.SPECIALIZES,
            USDTypes.SUBLAYERS,
            USDTypes.SUFFIXSUBSTITUTIONS,
            USDTypes.SYMMETRYARGUMENTS,
            USDTypes.SYMMETRYFUNCTION,
            USDTypes.UNIFORM,
            USDTypes.VARIANTS,
            USDTypes.VARIANTSET,
            USDTypes.VARIANTSETS,
            USDTypes.VARYING,
            USDTypes.TRUE
    );

    public static final TokenSet TYPES = TokenSet.create(
            USDTypes.BOOLTYPE,
            USDTypes.UCHARTYPE,
            USDTypes.INTTYPE,
            USDTypes.UINTTYPE,
            USDTypes.UINT64TYPE,
            USDTypes.HALFTYPE,
            USDTypes.FLOATTYPE,
            USDTypes.DOUBLETYPE,
            USDTypes.STRINGTYPE,
            USDTypes.TOKENTYPE,
            USDTypes.ASSETTYPE,
            USDTypes.MATRIX2DTYPE,
            USDTypes.MATRIX3DTYPE,
            USDTypes.MATRIX4DTYPE,
            USDTypes.QUATDTYPE,
            USDTypes.QUATFTYPE,
            USDTypes.QUATHTYPE,
            USDTypes.DOUBLE2TYPE,
            USDTypes.FLOAT2TYPE,
            USDTypes.HALF2TYPE,
            USDTypes.INT2TYPE,
            USDTypes.DOUBLE3TYPE,
            USDTypes.FLOAT3TYPE,
            USDTypes.HALF3TYPE,
            USDTypes.INT3TYPE,
            USDTypes.DOUBLE4TYPE,
            USDTypes.FLOAT4TYPE,
            USDTypes.HALF4TYPE,
            USDTypes.INT4TYPE,
            USDTypes.POINT3DTYPE,
            USDTypes.POINT3FTYPE,
            USDTypes.POINT3HTYPE,
            USDTypes.NORMAL3DTYPE,
            USDTypes.NORMAL3FTYPE,
            USDTypes.NORMAL3HTYPE,
            USDTypes.VECTOR3DTYPE,
            USDTypes.VECTOR3FTYPE,
            USDTypes.VECTOR3HTYPE,
            USDTypes.COLOR3DTYPE,
            USDTypes.COLOR3FTYPE,
            USDTypes.COLOR3HTYPE,
            USDTypes.COLOR4DTYPE,
            USDTypes.COLOR4FTYPE,
            USDTypes.COLOR4HTYPE,
            USDTypes.FRAME4DTYPE,
            USDTypes.TEXCOORD2HTYPE,
            USDTypes.TEXCOORD2DTYPE,
            USDTypes.TEXCOORD2FTYPE,
            USDTypes.TEXCOORD3HTYPE,
            USDTypes.TEXCOORD3DTYPE,
            USDTypes.TEXCOORD3FTYPE,
            USDTypes.TRANSFORMTYPE,
            USDTypes.POINTINDEXTYPE,
            USDTypes.EDGEINDEXTYPE,
            USDTypes.FACEINDEXTYPE
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
