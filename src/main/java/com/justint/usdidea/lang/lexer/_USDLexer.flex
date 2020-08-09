package com.justint.usdidea.lang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.justint.usdidea.lang.psi.USDTypes.*;

%%

%{
  public _USDLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _USDLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

USDDECLARATION=#[^\r\n]*
STRING=\"\"\"[^(\"\"\")]*\"\"\"|\"[^\"]*\"|'[^']*'
NUMBER=(\+|\-)?[:digit:]+
FLOATNUMBER=(\+|\-)?[:digit:]+(\.[:digit:]+)?([eE][+\-][:digit:]+)?
ALPHA=[a-zA-Z_0-9]+
COMMENT="//".*
BLOCKCOMMENT="/"\*([^\*]|(\*+[^\*/]))*(\*+"/")?
ASSETREFERENCE=@([^@]+)?@|@@@(([^@]|@{1,2}[^@]|\\@@@)+)?(@{0,2})@@@
PATHREFERENCE=\<[^\<\>\r\n]*\>

%%
<YYINITIAL> {
  {WHITE_SPACE}              { return WHITE_SPACE; }

  "add"                      { return ADD; }
  "append"                   { return APPEND; }
  "assetInfo"                { return ASSETINFO; }
  "attributes"               { return ATTRIBUTES; }
  "class"                    { return CLASS; }
  "config"                   { return CONFIG; }
  "connect"                  { return CONNECT; }
  "custom"                   { return CUSTOM; }
  "customData"               { return CUSTOMDATA; }
  "default"                  { return DEFAULT; }
  "def"                      { return DEF; }
  "delete"                   { return DELETE; }
  "dictionary"               { return DICTIONARY; }
  "displayUnit"              { return DISPLAYUNIT; }
  "doc"                      { return DOC; }
  "inherits"                 { return INHERITS; }
  "kind"                     { return KIND; }
  "mapper"                   { return MAPPER; }
  "nameChildren"             { return NAMECHILDREN; }
  "None"                     { return NONE; }
  "offset"                   { return OFFSET; }
  "over"                     { return OVER; }
  "payload"                  { return PAYLOAD; }
  "permission"               { return PERMISSION; }
  "prefixSubstitutions"      { return PREFIXSUBSTITUTIONS; }
  "prepend"                  { return PREPEND; }
  "properties"               { return PROPERTIES; }
  "references"               { return REFERENCES; }
  "relocates"                { return RELOCATES; }
  "rel"                      { return REL; }
  "reorder"                  { return REORDER; }
  "rootPrims"                { return ROOTPRIMS; }
  "subLayers"                { return SUBLAYERS; }
  "suffixSubstitutions"      { return SUFFIXSUBSTITUTIONS; }
  "specializes"              { return SPECIALIZES; }
  "symmetryArguments"        { return SYMMETRYARGUMENTS; }
  "symmetryFunction"         { return SYMMETRYFUNCTION; }
  "uniform"                  { return UNIFORM; }
  "variantSet"               { return VARIANTSET; }
  "variantSets"              { return VARIANTSETS; }
  "variants"                 { return VARIANTS; }
  "varying"                  { return VARYING; }
  "interpolation"            { return INTERPOLATION; }
  "."                        { return PERIOD; }
  ","                        { return COMMA; }
  ":"                        { return COLON; }
  "="                        { return EQUALS; }
  "["                        { return LEFTBRACKET; }
  "]"                        { return RIGHTBRACKET; }
  "("                        { return LEFTPARENS; }
  ")"                        { return RIGHTPARENS; }
  "{"                        { return LEFTBRACE; }
  "}"                        { return RIGHTBRACE; }
  "true"                     { return TRUE; }
  "false"                    { return FALSE; }
  "bool"                     { return BOOLTYPE; }
  "uchar"                    { return UCHARTYPE; }
  "int"                      { return INTTYPE; }
  "uint"                     { return UINTTYPE; }
  "int64"                    { return INT64TYPE; }
  "uint64"                   { return UINT64TYPE; }
  "half"                     { return HALFTYPE; }
  "float"                    { return FLOATTYPE; }
  "double"                   { return DOUBLETYPE; }
  "string"                   { return STRINGTYPE; }
  "token"                    { return TOKENTYPE; }
  "asset"                    { return ASSETTYPE; }
  "matrix2d"                 { return MATRIX2DTYPE; }
  "matrix3d"                 { return MATRIX3DTYPE; }
  "matrix4d"                 { return MATRIX4DTYPE; }
  "quatd"                    { return QUATDTYPE; }
  "quatf"                    { return QUATFTYPE; }
  "quath"                    { return QUATHTYPE; }
  "double2"                  { return DOUBLE2TYPE; }
  "float2"                   { return FLOAT2TYPE; }
  "half2"                    { return HALF2TYPE; }
  "int2"                     { return INT2TYPE; }
  "double3"                  { return DOUBLE3TYPE; }
  "float3"                   { return FLOAT3TYPE; }
  "half3"                    { return HALF3TYPE; }
  "int3"                     { return INT3TYPE; }
  "double4"                  { return DOUBLE4TYPE; }
  "float4"                   { return FLOAT4TYPE; }
  "half4"                    { return HALF4TYPE; }
  "int4"                     { return INT4TYPE; }
  "point3d"                  { return POINT3DTYPE; }
  "point3f"                  { return POINT3FTYPE; }
  "point3h"                  { return POINT3HTYPE; }
  "normal3d"                 { return NORMAL3DTYPE; }
  "normal3f"                 { return NORMAL3FTYPE; }
  "normal3h"                 { return NORMAL3HTYPE; }
  "vector3d"                 { return VECTOR3DTYPE; }
  "vector3f"                 { return VECTOR3FTYPE; }
  "vector3h"                 { return VECTOR3HTYPE; }
  "color3d"                  { return COLOR3DTYPE; }
  "color3f"                  { return COLOR3FTYPE; }
  "color3h"                  { return COLOR3HTYPE; }
  "color4d"                  { return COLOR4DTYPE; }
  "color4f"                  { return COLOR4FTYPE; }
  "color4h"                  { return COLOR4HTYPE; }
  "frame4d"                  { return FRAME4DTYPE; }
  "texCoord2h"               { return TEXCOORD2HTYPE; }
  "texCoord2d"               { return TEXCOORD2DTYPE; }
  "texCoord2f"               { return TEXCOORD2FTYPE; }
  "texCoord3h"               { return TEXCOORD3HTYPE; }
  "texCoord3d"               { return TEXCOORD3DTYPE; }
  "texCoord3f"               { return TEXCOORD3FTYPE; }
  "Transform"                { return TRANSFORMTYPE; }
  "PointIndex"               { return POINTINDEXTYPE; }
  "EdgeIndex"                { return EDGEINDEXTYPE; }
  "FaceIndex"                { return FACEINDEXTYPE; }

  {USDDECLARATION}           { return USDDECLARATION; }
  {STRING}                   { return STRING; }
  {NUMBER}                   { return NUMBER; }
  {FLOATNUMBER}              { return FLOATNUMBER; }
  {ALPHA}                    { return ALPHA; }
  {COMMENT}                  { return COMMENT; }
  {BLOCKCOMMENT}             { return BLOCKCOMMENT; }
  {ASSETREFERENCE}           { return ASSETREFERENCE; }
  {PATHREFERENCE}            { return PATHREFERENCE; }

}

[^] { return BAD_CHARACTER; }
