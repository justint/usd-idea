// This is a generated file. Not intended for manual editing.
package com.justint.usdidea.lang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.justint.usdidea.lang.psi.impl.*;

public interface USDTypes {

  IElementType ARRAY = new USDElementType("ARRAY");
  IElementType ARRAY_ATTRIBUTE_TYPE = new USDElementType("ARRAY_ATTRIBUTE_TYPE");
  IElementType ATTRIBUTE_NAME = new USDElementType("ATTRIBUTE_NAME");
  IElementType ATTRIBUTE_PROPERTY = new USDElementType("ATTRIBUTE_PROPERTY");
  IElementType ATTRIBUTE_TYPE = new USDElementType("ATTRIBUTE_TYPE");
  IElementType ATTRIBUTE_VALUE = new USDElementType("ATTRIBUTE_VALUE");
  IElementType BASIC_DATA_TYPE = new USDElementType("BASIC_DATA_TYPE");
  IElementType BODY = new USDElementType("BODY");
  IElementType COMPOSITION_ARC = new USDElementType("COMPOSITION_ARC");
  IElementType DICT = new USDElementType("DICT");
  IElementType DICT_KEY = new USDElementType("DICT_KEY");
  IElementType DICT_VALUE = new USDElementType("DICT_VALUE");
  IElementType FRAME_NUMBER = new USDElementType("FRAME_NUMBER");
  IElementType IDENTIFIER = new USDElementType("IDENTIFIER");
  IElementType INTERPOLATED_ARRAY = new USDElementType("INTERPOLATED_ARRAY");
  IElementType ITEM = new USDElementType("ITEM");
  IElementType LIST_EDIT_ACTION = new USDElementType("LIST_EDIT_ACTION");
  IElementType METADATA = new USDElementType("METADATA");
  IElementType METADATA_COMMENT = new USDElementType("METADATA_COMMENT");
  IElementType METADATA_KEY = new USDElementType("METADATA_KEY");
  IElementType METADATA_VALUE = new USDElementType("METADATA_VALUE");
  IElementType NAMESPACED_IDENTIFIER = new USDElementType("NAMESPACED_IDENTIFIER");
  IElementType PRIM_NAME = new USDElementType("PRIM_NAME");
  IElementType PRIM_SPEC = new USDElementType("PRIM_SPEC");
  IElementType PROPERTY = new USDElementType("PROPERTY");
  IElementType RELATIONSHIP_PROPERTY = new USDElementType("RELATIONSHIP_PROPERTY");
  IElementType ROLE_DATA_TYPE = new USDElementType("ROLE_DATA_TYPE");
  IElementType SINGLE_ATTRIBUTE_TYPE = new USDElementType("SINGLE_ATTRIBUTE_TYPE");
  IElementType SPECIFIER = new USDElementType("SPECIFIER");
  IElementType TIME_SAMPLE = new USDElementType("TIME_SAMPLE");
  IElementType TYPENAME = new USDElementType("TYPENAME");
  IElementType VARIANT_SET_BODY = new USDElementType("VARIANT_SET_BODY");
  IElementType VARIANT_SET_ITEM_BODY = new USDElementType("VARIANT_SET_ITEM_BODY");
  IElementType VARIANT_SET_KEY = new USDElementType("VARIANT_SET_KEY");
  IElementType VECTOR = new USDElementType("VECTOR");

  IElementType ADD = new USDTokenType("add");
  IElementType ALPHA = new USDTokenType("alpha");
  IElementType APPEND = new USDTokenType("append");
  IElementType ASSETREFERENCE = new USDTokenType("assetReference");
  IElementType ASSETTYPE = new USDTokenType("asset");
  IElementType ATTRIBUTES = new USDTokenType("attributes");
  IElementType BLOCKCOMMENT = new USDTokenType("blockcomment");
  IElementType BOOLTYPE = new USDTokenType("bool");
  IElementType CLASS = new USDTokenType("class");
  IElementType COLON = new USDTokenType(":");
  IElementType COLOR3DTYPE = new USDTokenType("color3d");
  IElementType COLOR3FTYPE = new USDTokenType("color3f");
  IElementType COLOR3HTYPE = new USDTokenType("color3h");
  IElementType COLOR4DTYPE = new USDTokenType("color4d");
  IElementType COLOR4FTYPE = new USDTokenType("color4f");
  IElementType COLOR4HTYPE = new USDTokenType("color4h");
  IElementType COMMA = new USDTokenType(",");
  IElementType COMMENT = new USDTokenType("comment");
  IElementType CONFIG = new USDTokenType("config");
  IElementType CONNECT = new USDTokenType("connect");
  IElementType CUSTOM = new USDTokenType("custom");
  IElementType CUSTOMDATA = new USDTokenType("customData");
  IElementType DEF = new USDTokenType("def");
  IElementType DEFAULT = new USDTokenType("default");
  IElementType DELETE = new USDTokenType("delete");
  IElementType DICTIONARY = new USDTokenType("dictionary");
  IElementType DISPLAYUNIT = new USDTokenType("displayUnit");
  IElementType DOC = new USDTokenType("doc");
  IElementType DOUBLE2TYPE = new USDTokenType("double2");
  IElementType DOUBLE3TYPE = new USDTokenType("double3");
  IElementType DOUBLE4TYPE = new USDTokenType("double4");
  IElementType DOUBLETYPE = new USDTokenType("double");
  IElementType EDGEINDEXTYPE = new USDTokenType("EdgeIndex");
  IElementType EQUALS = new USDTokenType("=");
  IElementType FACEINDEXTYPE = new USDTokenType("FaceIndex");
  IElementType FLOAT2TYPE = new USDTokenType("float2");
  IElementType FLOAT3TYPE = new USDTokenType("float3");
  IElementType FLOAT4TYPE = new USDTokenType("float4");
  IElementType FLOATNUMBER = new USDTokenType("floatnumber");
  IElementType FLOATTYPE = new USDTokenType("float");
  IElementType FRAME4DTYPE = new USDTokenType("frame4d");
  IElementType HALF2TYPE = new USDTokenType("half2");
  IElementType HALF3TYPE = new USDTokenType("half3");
  IElementType HALF4TYPE = new USDTokenType("half4");
  IElementType HALFTYPE = new USDTokenType("half");
  IElementType INHERITS = new USDTokenType("inherits");
  IElementType INT2TYPE = new USDTokenType("int2");
  IElementType INT3TYPE = new USDTokenType("int3");
  IElementType INT4TYPE = new USDTokenType("int4");
  IElementType INT64TYPE = new USDTokenType("int64");
  IElementType INTERPOLATION = new USDTokenType("interpolation");
  IElementType INTTYPE = new USDTokenType("int");
  IElementType KIND = new USDTokenType("kind");
  IElementType LEFTBRACE = new USDTokenType("{");
  IElementType LEFTBRACKET = new USDTokenType("[");
  IElementType LEFTPARENS = new USDTokenType("(");
  IElementType MAPPER = new USDTokenType("mapper");
  IElementType MATRIX2DTYPE = new USDTokenType("matrix2d");
  IElementType MATRIX3DTYPE = new USDTokenType("matrix3d");
  IElementType MATRIX4DTYPE = new USDTokenType("matrix4d");
  IElementType NAMECHILDREN = new USDTokenType("nameChildren");
  IElementType NONE = new USDTokenType("None");
  IElementType NORMAL3DTYPE = new USDTokenType("normal3d");
  IElementType NORMAL3FTYPE = new USDTokenType("normal3f");
  IElementType NORMAL3HTYPE = new USDTokenType("normal3h");
  IElementType NUMBER = new USDTokenType("number");
  IElementType OFFSET = new USDTokenType("offset");
  IElementType OVER = new USDTokenType("over");
  IElementType PATHREFERENCE = new USDTokenType("pathReference");
  IElementType PAYLOAD = new USDTokenType("payload");
  IElementType PERIOD = new USDTokenType(".");
  IElementType PERMISSION = new USDTokenType("permission");
  IElementType POINT3DTYPE = new USDTokenType("point3d");
  IElementType POINT3FTYPE = new USDTokenType("point3f");
  IElementType POINT3HTYPE = new USDTokenType("point3h");
  IElementType POINTINDEXTYPE = new USDTokenType("PointIndex");
  IElementType PREFIXSUBSTITUTIONS = new USDTokenType("prefixSubstitutions");
  IElementType PREPEND = new USDTokenType("prepend");
  IElementType PROPERTIES = new USDTokenType("properties");
  IElementType QUATDTYPE = new USDTokenType("quatd");
  IElementType QUATFTYPE = new USDTokenType("quatf");
  IElementType QUATHTYPE = new USDTokenType("quath");
  IElementType REFERENCES = new USDTokenType("references");
  IElementType REL = new USDTokenType("rel");
  IElementType RELOCATES = new USDTokenType("relocates");
  IElementType REORDER = new USDTokenType("reorder");
  IElementType RIGHTBRACE = new USDTokenType("}");
  IElementType RIGHTBRACKET = new USDTokenType("]");
  IElementType RIGHTPARENS = new USDTokenType(")");
  IElementType ROOTPRIMS = new USDTokenType("rootPrims");
  IElementType SPECIALIZES = new USDTokenType("specializes");
  IElementType STRING = new USDTokenType("string");
  IElementType STRINGTYPE = new USDTokenType("string");
  IElementType SUBLAYERS = new USDTokenType("subLayers");
  IElementType SUFFIXSUBSTITUTIONS = new USDTokenType("suffixSubstitutions");
  IElementType SYMMETRYARGUMENTS = new USDTokenType("symmetryArguments");
  IElementType SYMMETRYFUNCTION = new USDTokenType("symmetryFunction");
  IElementType TEXCOORD2DTYPE = new USDTokenType("texCoord2d");
  IElementType TEXCOORD2FTYPE = new USDTokenType("texCoord2f");
  IElementType TEXCOORD2HTYPE = new USDTokenType("texCoord2h");
  IElementType TEXCOORD3DTYPE = new USDTokenType("texCoord3d");
  IElementType TEXCOORD3F = new USDTokenType("texCoord3f");
  IElementType TEXCOORD3FTYPE = new USDTokenType("texCoord3ftype");
  IElementType TEXCOORD3HTYPE = new USDTokenType("texCoord3h");
  IElementType TOKENTYPE = new USDTokenType("token");
  IElementType TRANSFORMTYPE = new USDTokenType("Transform");
  IElementType UCHARTYPE = new USDTokenType("uchar");
  IElementType UINT64TYPE = new USDTokenType("uint64");
  IElementType UINTTYPE = new USDTokenType("uint");
  IElementType UNIFORM = new USDTokenType("uniform");
  IElementType USDDECLARATION = new USDTokenType("usdDeclaration");
  IElementType VARIANTS = new USDTokenType("variants");
  IElementType VARIANTSET = new USDTokenType("variantSet");
  IElementType VARIANTSETS = new USDTokenType("variantSets");
  IElementType VARYING = new USDTokenType("varying");
  IElementType VECTOR3DTYPE = new USDTokenType("vector3d");
  IElementType VECTOR3FTYPE = new USDTokenType("vector3f");
  IElementType VECTOR3HTYPE = new USDTokenType("vector3h");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARRAY) {
        return new usdArrayImpl(node);
      }
      else if (type == ARRAY_ATTRIBUTE_TYPE) {
        return new usdArrayAttributeTypeImpl(node);
      }
      else if (type == ATTRIBUTE_NAME) {
        return new usdAttributeNameImpl(node);
      }
      else if (type == ATTRIBUTE_PROPERTY) {
        return new usdAttributePropertyImpl(node);
      }
      else if (type == ATTRIBUTE_TYPE) {
        return new usdAttributeTypeImpl(node);
      }
      else if (type == ATTRIBUTE_VALUE) {
        return new usdAttributeValueImpl(node);
      }
      else if (type == BASIC_DATA_TYPE) {
        return new usdBasicDataTypeImpl(node);
      }
      else if (type == BODY) {
        return new usdBodyImpl(node);
      }
      else if (type == COMPOSITION_ARC) {
        return new usdCompositionArcImpl(node);
      }
      else if (type == DICT) {
        return new usdDictImpl(node);
      }
      else if (type == DICT_KEY) {
        return new usdDictKeyImpl(node);
      }
      else if (type == DICT_VALUE) {
        return new usdDictValueImpl(node);
      }
      else if (type == FRAME_NUMBER) {
        return new usdFrameNumberImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new usdIdentifierImpl(node);
      }
      else if (type == INTERPOLATED_ARRAY) {
        return new usdInterpolatedArrayImpl(node);
      }
      else if (type == ITEM) {
        return new usdItemImpl(node);
      }
      else if (type == LIST_EDIT_ACTION) {
        return new usdListEditActionImpl(node);
      }
      else if (type == METADATA) {
        return new usdMetadataImpl(node);
      }
      else if (type == METADATA_COMMENT) {
        return new usdMetadataCommentImpl(node);
      }
      else if (type == METADATA_KEY) {
        return new usdMetadataKeyImpl(node);
      }
      else if (type == METADATA_VALUE) {
        return new usdMetadataValueImpl(node);
      }
      else if (type == NAMESPACED_IDENTIFIER) {
        return new usdNamespacedIdentifierImpl(node);
      }
      else if (type == PRIM_NAME) {
        return new usdPrimNameImpl(node);
      }
      else if (type == PRIM_SPEC) {
        return new usdPrimSpecImpl(node);
      }
      else if (type == PROPERTY) {
        return new usdPropertyImpl(node);
      }
      else if (type == RELATIONSHIP_PROPERTY) {
        return new usdRelationshipPropertyImpl(node);
      }
      else if (type == ROLE_DATA_TYPE) {
        return new usdRoleDataTypeImpl(node);
      }
      else if (type == SINGLE_ATTRIBUTE_TYPE) {
        return new usdSingleAttributeTypeImpl(node);
      }
      else if (type == SPECIFIER) {
        return new usdSpecifierImpl(node);
      }
      else if (type == TIME_SAMPLE) {
        return new usdTimeSampleImpl(node);
      }
      else if (type == TYPENAME) {
        return new usdTypenameImpl(node);
      }
      else if (type == VARIANT_SET_BODY) {
        return new usdVariantSetBodyImpl(node);
      }
      else if (type == VARIANT_SET_ITEM_BODY) {
        return new usdVariantSetItemBodyImpl(node);
      }
      else if (type == VARIANT_SET_KEY) {
        return new usdVariantSetKeyImpl(node);
      }
      else if (type == VECTOR) {
        return new usdVectorImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
