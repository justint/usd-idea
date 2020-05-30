// This is a generated file. Not intended for manual editing.
package com.justint.usdidea.lang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.justint.usdidea.lang.psi.USDTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class USDParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return usdFile(b, l + 1);
  }

  /* ********************************************************** */
  // leftbracket [!rightbracket Item (comma Item)*] rightbracket | leftbracket rightbracket
  public static boolean Array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Array")) return false;
    if (!nextTokenIs(b, LEFTBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Array_0(b, l + 1);
    if (!r) r = parseTokens(b, 0, LEFTBRACKET, RIGHTBRACKET);
    exit_section_(b, m, ARRAY, r);
    return r;
  }

  // leftbracket [!rightbracket Item (comma Item)*] rightbracket
  private static boolean Array_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Array_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFTBRACKET);
    r = r && Array_0_1(b, l + 1);
    r = r && consumeToken(b, RIGHTBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // [!rightbracket Item (comma Item)*]
  private static boolean Array_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Array_0_1")) return false;
    Array_0_1_0(b, l + 1);
    return true;
  }

  // !rightbracket Item (comma Item)*
  private static boolean Array_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Array_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Array_0_1_0_0(b, l + 1);
    r = r && Item(b, l + 1);
    r = r && Array_0_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !rightbracket
  private static boolean Array_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Array_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RIGHTBRACKET);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (comma Item)*
  private static boolean Array_0_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Array_0_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Array_0_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Array_0_1_0_2", c)) break;
    }
    return true;
  }

  // comma Item
  private static boolean Array_0_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Array_0_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Item(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SingleAttributeType [leftbracket rightbracket]
  public static boolean ArrayAttributeType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayAttributeType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARRAY_ATTRIBUTE_TYPE, "<array attribute type>");
    r = SingleAttributeType(b, l + 1);
    r = r && ArrayAttributeType_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [leftbracket rightbracket]
  private static boolean ArrayAttributeType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayAttributeType_1")) return false;
    parseTokens(b, 0, LEFTBRACKET, RIGHTBRACKET);
    return true;
  }

  /* ********************************************************** */
  // (NamespacedIdentifier | Identifier) (period (connect | Identifier))*
  public static boolean AttributeName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeName")) return false;
    if (!nextTokenIs(b, ALPHA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AttributeName_0(b, l + 1);
    r = r && AttributeName_1(b, l + 1);
    exit_section_(b, m, ATTRIBUTE_NAME, r);
    return r;
  }

  // NamespacedIdentifier | Identifier
  private static boolean AttributeName_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeName_0")) return false;
    boolean r;
    r = NamespacedIdentifier(b, l + 1);
    if (!r) r = Identifier(b, l + 1);
    return r;
  }

  // (period (connect | Identifier))*
  private static boolean AttributeName_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeName_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!AttributeName_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "AttributeName_1", c)) break;
    }
    return true;
  }

  // period (connect | Identifier)
  private static boolean AttributeName_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeName_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PERIOD);
    r = r && AttributeName_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // connect | Identifier
  private static boolean AttributeName_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeName_1_0_1")) return false;
    boolean r;
    r = consumeToken(b, CONNECT);
    if (!r) r = Identifier(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // [uniform | custom] (ListEditAction? rel AttributeName | AttributeType AttributeName | ListEditAction? CompositionArc) [equals AttributeValue]
  public static boolean AttributeProperty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeProperty")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_PROPERTY, "<attribute property>");
    r = AttributeProperty_0(b, l + 1);
    r = r && AttributeProperty_1(b, l + 1);
    r = r && AttributeProperty_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [uniform | custom]
  private static boolean AttributeProperty_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeProperty_0")) return false;
    AttributeProperty_0_0(b, l + 1);
    return true;
  }

  // uniform | custom
  private static boolean AttributeProperty_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeProperty_0_0")) return false;
    boolean r;
    r = consumeToken(b, UNIFORM);
    if (!r) r = consumeToken(b, CUSTOM);
    return r;
  }

  // ListEditAction? rel AttributeName | AttributeType AttributeName | ListEditAction? CompositionArc
  private static boolean AttributeProperty_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeProperty_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AttributeProperty_1_0(b, l + 1);
    if (!r) r = AttributeProperty_1_1(b, l + 1);
    if (!r) r = AttributeProperty_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ListEditAction? rel AttributeName
  private static boolean AttributeProperty_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeProperty_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AttributeProperty_1_0_0(b, l + 1);
    r = r && consumeToken(b, REL);
    r = r && AttributeName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ListEditAction?
  private static boolean AttributeProperty_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeProperty_1_0_0")) return false;
    ListEditAction(b, l + 1);
    return true;
  }

  // AttributeType AttributeName
  private static boolean AttributeProperty_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeProperty_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AttributeType(b, l + 1);
    r = r && AttributeName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ListEditAction? CompositionArc
  private static boolean AttributeProperty_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeProperty_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AttributeProperty_1_2_0(b, l + 1);
    r = r && CompositionArc(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ListEditAction?
  private static boolean AttributeProperty_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeProperty_1_2_0")) return false;
    ListEditAction(b, l + 1);
    return true;
  }

  // [equals AttributeValue]
  private static boolean AttributeProperty_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeProperty_2")) return false;
    AttributeProperty_2_0(b, l + 1);
    return true;
  }

  // equals AttributeValue
  private static boolean AttributeProperty_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeProperty_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && AttributeValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ArrayAttributeType | SingleAttributeType
  public static boolean AttributeType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_TYPE, "<attribute type>");
    r = ArrayAttributeType(b, l + 1);
    if (!r) r = SingleAttributeType(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Item
  public static boolean AttributeValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AttributeValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_VALUE, "<attribute value>");
    r = Item(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // booltype | uchartype | inttype | uinttype | int64type | uint64type | halftype | floattype | doubletype | stringtype | tokentype | assettype | matrix2dtype | matrix3dtype | matrix4dtype | quatdtype | quatftype | quathtype | double2type | float2type | half2type | int2type | double3type | float3type | half3type | int3type | double4type | float4type | half4type | int4type
  public static boolean BasicDataType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BasicDataType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BASIC_DATA_TYPE, "<basic data type>");
    r = consumeToken(b, BOOLTYPE);
    if (!r) r = consumeToken(b, UCHARTYPE);
    if (!r) r = consumeToken(b, INTTYPE);
    if (!r) r = consumeToken(b, UINTTYPE);
    if (!r) r = consumeToken(b, INT64TYPE);
    if (!r) r = consumeToken(b, UINT64TYPE);
    if (!r) r = consumeToken(b, HALFTYPE);
    if (!r) r = consumeToken(b, FLOATTYPE);
    if (!r) r = consumeToken(b, DOUBLETYPE);
    if (!r) r = consumeToken(b, STRINGTYPE);
    if (!r) r = consumeToken(b, TOKENTYPE);
    if (!r) r = consumeToken(b, ASSETTYPE);
    if (!r) r = consumeToken(b, MATRIX2DTYPE);
    if (!r) r = consumeToken(b, MATRIX3DTYPE);
    if (!r) r = consumeToken(b, MATRIX4DTYPE);
    if (!r) r = consumeToken(b, QUATDTYPE);
    if (!r) r = consumeToken(b, QUATFTYPE);
    if (!r) r = consumeToken(b, QUATHTYPE);
    if (!r) r = consumeToken(b, DOUBLE2TYPE);
    if (!r) r = consumeToken(b, FLOAT2TYPE);
    if (!r) r = consumeToken(b, HALF2TYPE);
    if (!r) r = consumeToken(b, INT2TYPE);
    if (!r) r = consumeToken(b, DOUBLE3TYPE);
    if (!r) r = consumeToken(b, FLOAT3TYPE);
    if (!r) r = consumeToken(b, HALF3TYPE);
    if (!r) r = consumeToken(b, INT3TYPE);
    if (!r) r = consumeToken(b, DOUBLE4TYPE);
    if (!r) r = consumeToken(b, FLOAT4TYPE);
    if (!r) r = consumeToken(b, HALF4TYPE);
    if (!r) r = consumeToken(b, INT4TYPE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // leftbrace [!rightbrace (PropertySpec | PrimSpec)* ] rightbrace
  public static boolean Body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Body")) return false;
    if (!nextTokenIs(b, LEFTBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFTBRACE);
    r = r && Body_1(b, l + 1);
    r = r && consumeToken(b, RIGHTBRACE);
    exit_section_(b, m, BODY, r);
    return r;
  }

  // [!rightbrace (PropertySpec | PrimSpec)* ]
  private static boolean Body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Body_1")) return false;
    Body_1_0(b, l + 1);
    return true;
  }

  // !rightbrace (PropertySpec | PrimSpec)*
  private static boolean Body_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Body_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Body_1_0_0(b, l + 1);
    r = r && Body_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !rightbrace
  private static boolean Body_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Body_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RIGHTBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (PropertySpec | PrimSpec)*
  private static boolean Body_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Body_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Body_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Body_1_0_1", c)) break;
    }
    return true;
  }

  // PropertySpec | PrimSpec
  private static boolean Body_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Body_1_0_1_0")) return false;
    boolean r;
    r = PropertySpec(b, l + 1);
    if (!r) r = PrimSpec(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // true | false
  public static boolean Boolean(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Boolean")) return false;
    if (!nextTokenIs(b, "<boolean>", FALSE, TRUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN, "<boolean>");
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // subLayers | inherits | variantSets | references | payload | specializes | nameChildren
  public static boolean CompositionArc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CompositionArc")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPOSITION_ARC, "<composition arc>");
    r = consumeToken(b, SUBLAYERS);
    if (!r) r = consumeToken(b, INHERITS);
    if (!r) r = consumeToken(b, VARIANTSETS);
    if (!r) r = consumeToken(b, REFERENCES);
    if (!r) r = consumeToken(b, PAYLOAD);
    if (!r) r = consumeToken(b, SPECIALIZES);
    if (!r) r = consumeToken(b, NAMECHILDREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // leftbrace [!rightbrace DictKey equals DictValue (DictKey equals DictValue)*] rightbrace | leftbrace rightbrace
  public static boolean Dict(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Dict")) return false;
    if (!nextTokenIs(b, LEFTBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Dict_0(b, l + 1);
    if (!r) r = parseTokens(b, 0, LEFTBRACE, RIGHTBRACE);
    exit_section_(b, m, DICT, r);
    return r;
  }

  // leftbrace [!rightbrace DictKey equals DictValue (DictKey equals DictValue)*] rightbrace
  private static boolean Dict_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Dict_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFTBRACE);
    r = r && Dict_0_1(b, l + 1);
    r = r && consumeToken(b, RIGHTBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [!rightbrace DictKey equals DictValue (DictKey equals DictValue)*]
  private static boolean Dict_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Dict_0_1")) return false;
    Dict_0_1_0(b, l + 1);
    return true;
  }

  // !rightbrace DictKey equals DictValue (DictKey equals DictValue)*
  private static boolean Dict_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Dict_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Dict_0_1_0_0(b, l + 1);
    r = r && DictKey(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && DictValue(b, l + 1);
    r = r && Dict_0_1_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !rightbrace
  private static boolean Dict_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Dict_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RIGHTBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (DictKey equals DictValue)*
  private static boolean Dict_0_1_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Dict_0_1_0_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Dict_0_1_0_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Dict_0_1_0_4", c)) break;
    }
    return true;
  }

  // DictKey equals DictValue
  private static boolean Dict_0_1_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Dict_0_1_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = DictKey(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && DictValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // AttributeType Identifier
  public static boolean DictKey(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DictKey")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DICT_KEY, "<dict key>");
    r = AttributeType(b, l + 1);
    r = r && Identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Item
  public static boolean DictValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DictValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DICT_VALUE, "<dict value>");
    r = Item(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // number
  public static boolean FrameNumber(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FrameNumber")) return false;
    if (!nextTokenIs(b, NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUMBER);
    exit_section_(b, m, FRAME_NUMBER, r);
    return r;
  }

  /* ********************************************************** */
  // alpha (alpha | number)*
  public static boolean Identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Identifier")) return false;
    if (!nextTokenIs(b, ALPHA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ALPHA);
    r = r && Identifier_1(b, l + 1);
    exit_section_(b, m, IDENTIFIER, r);
    return r;
  }

  // (alpha | number)*
  private static boolean Identifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Identifier_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Identifier_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Identifier_1", c)) break;
    }
    return true;
  }

  // alpha | number
  private static boolean Identifier_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Identifier_1_0")) return false;
    boolean r;
    r = consumeToken(b, ALPHA);
    if (!r) r = consumeToken(b, NUMBER);
    return r;
  }

  /* ********************************************************** */
  // Array (leftparens interpolation equals string rightparens)?
  public static boolean InterpolatedArray(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterpolatedArray")) return false;
    if (!nextTokenIs(b, LEFTBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Array(b, l + 1);
    r = r && InterpolatedArray_1(b, l + 1);
    exit_section_(b, m, INTERPOLATED_ARRAY, r);
    return r;
  }

  // (leftparens interpolation equals string rightparens)?
  private static boolean InterpolatedArray_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterpolatedArray_1")) return false;
    InterpolatedArray_1_0(b, l + 1);
    return true;
  }

  // leftparens interpolation equals string rightparens
  private static boolean InterpolatedArray_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterpolatedArray_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LEFTPARENS, INTERPOLATION, EQUALS, STRING, RIGHTPARENS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // InterpolatedArray | Array | Vector | string | number | floatnumber | ReferenceItem | Dict | TimeSample | Boolean
  public static boolean Item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ITEM, "<item>");
    r = InterpolatedArray(b, l + 1);
    if (!r) r = Array(b, l + 1);
    if (!r) r = Vector(b, l + 1);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, FLOATNUMBER);
    if (!r) r = ReferenceItem(b, l + 1);
    if (!r) r = Dict(b, l + 1);
    if (!r) r = TimeSample(b, l + 1);
    if (!r) r = Boolean(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // add | append | prepend | delete | reorder
  public static boolean ListEditAction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ListEditAction")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LIST_EDIT_ACTION, "<list edit action>");
    r = consumeToken(b, ADD);
    if (!r) r = consumeToken(b, APPEND);
    if (!r) r = consumeToken(b, PREPEND);
    if (!r) r = consumeToken(b, DELETE);
    if (!r) r = consumeToken(b, REORDER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // leftparens (!rightparens ( MetadataComment | [ListEditAction? MetadataKey equals MetadataValue]) )* rightparens
  public static boolean Metadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Metadata")) return false;
    if (!nextTokenIs(b, LEFTPARENS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFTPARENS);
    r = r && Metadata_1(b, l + 1);
    r = r && consumeToken(b, RIGHTPARENS);
    exit_section_(b, m, METADATA, r);
    return r;
  }

  // (!rightparens ( MetadataComment | [ListEditAction? MetadataKey equals MetadataValue]) )*
  private static boolean Metadata_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Metadata_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Metadata_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Metadata_1", c)) break;
    }
    return true;
  }

  // !rightparens ( MetadataComment | [ListEditAction? MetadataKey equals MetadataValue])
  private static boolean Metadata_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Metadata_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Metadata_1_0_0(b, l + 1);
    r = r && Metadata_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !rightparens
  private static boolean Metadata_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Metadata_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RIGHTPARENS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // MetadataComment | [ListEditAction? MetadataKey equals MetadataValue]
  private static boolean Metadata_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Metadata_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MetadataComment(b, l + 1);
    if (!r) r = Metadata_1_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ListEditAction? MetadataKey equals MetadataValue]
  private static boolean Metadata_1_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Metadata_1_0_1_1")) return false;
    Metadata_1_0_1_1_0(b, l + 1);
    return true;
  }

  // ListEditAction? MetadataKey equals MetadataValue
  private static boolean Metadata_1_0_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Metadata_1_0_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Metadata_1_0_1_1_0_0(b, l + 1);
    r = r && MetadataKey(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && MetadataValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ListEditAction?
  private static boolean Metadata_1_0_1_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Metadata_1_0_1_1_0_0")) return false;
    ListEditAction(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // string
  public static boolean MetadataComment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MetadataComment")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, METADATA_COMMENT, r);
    return r;
  }

  /* ********************************************************** */
  // Identifier | CompositionArc | SpecialMetadataKey
  public static boolean MetadataKey(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MetadataKey")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METADATA_KEY, "<metadata key>");
    r = Identifier(b, l + 1);
    if (!r) r = CompositionArc(b, l + 1);
    if (!r) r = SpecialMetadataKey(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Item
  public static boolean MetadataValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MetadataValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METADATA_VALUE, "<metadata value>");
    r = Item(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Identifier (colon Identifier)+
  public static boolean NamespacedIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamespacedIdentifier")) return false;
    if (!nextTokenIs(b, ALPHA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Identifier(b, l + 1);
    r = r && NamespacedIdentifier_1(b, l + 1);
    exit_section_(b, m, NAMESPACED_IDENTIFIER, r);
    return r;
  }

  // (colon Identifier)+
  private static boolean NamespacedIdentifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamespacedIdentifier_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = NamespacedIdentifier_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!NamespacedIdentifier_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "NamespacedIdentifier_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // colon Identifier
  private static boolean NamespacedIdentifier_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamespacedIdentifier_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // string
  public static boolean PrimName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimName")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, PRIM_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // Specifier Metadata? Body
  public static boolean PrimSpec(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimSpec")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIM_SPEC, "<prim spec>");
    r = Specifier(b, l + 1);
    r = r && PrimSpec_1(b, l + 1);
    r = r && Body(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Metadata?
  private static boolean PrimSpec_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimSpec_1")) return false;
    Metadata(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (AttributeProperty | RelationshipProperty) Metadata?
  public static boolean PropertySpec(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropertySpec")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY_SPEC, "<property spec>");
    r = PropertySpec_0(b, l + 1);
    r = r && PropertySpec_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // AttributeProperty | RelationshipProperty
  private static boolean PropertySpec_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropertySpec_0")) return false;
    boolean r;
    r = AttributeProperty(b, l + 1);
    if (!r) r = RelationshipProperty(b, l + 1);
    return r;
  }

  // Metadata?
  private static boolean PropertySpec_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropertySpec_1")) return false;
    Metadata(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // assetReference pathReference | assetReference | pathReference
  public static boolean ReferenceItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReferenceItem")) return false;
    if (!nextTokenIs(b, "<reference item>", ASSETREFERENCE, PATHREFERENCE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REFERENCE_ITEM, "<reference item>");
    r = parseTokens(b, 0, ASSETREFERENCE, PATHREFERENCE);
    if (!r) r = consumeToken(b, ASSETREFERENCE);
    if (!r) r = consumeToken(b, PATHREFERENCE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // variantSet string (equals VariantSetBody)?
  public static boolean RelationshipProperty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationshipProperty")) return false;
    if (!nextTokenIs(b, VARIANTSET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, VARIANTSET, STRING);
    r = r && RelationshipProperty_2(b, l + 1);
    exit_section_(b, m, RELATIONSHIP_PROPERTY, r);
    return r;
  }

  // (equals VariantSetBody)?
  private static boolean RelationshipProperty_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationshipProperty_2")) return false;
    RelationshipProperty_2_0(b, l + 1);
    return true;
  }

  // equals VariantSetBody
  private static boolean RelationshipProperty_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationshipProperty_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && VariantSetBody(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // point3dtype | point3ftype | point3htype | normal3dtype | normal3ftype | normal3htype | vector3dtype | vector3ftype | vector3htype | color3dtype | color3ftype | color3htype | color4dtype | color4ftype | color4htype | frame4dtype | texCoord2htype | texCoord2dtype | texCoord2ftype | texCoord3htype | texCoord3dtype | texCoord3ftype | Transformtype | PointIndextype | EdgeIndextype | FaceIndextype
  public static boolean RoleDataType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RoleDataType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ROLE_DATA_TYPE, "<role data type>");
    r = consumeToken(b, POINT3DTYPE);
    if (!r) r = consumeToken(b, POINT3FTYPE);
    if (!r) r = consumeToken(b, POINT3HTYPE);
    if (!r) r = consumeToken(b, NORMAL3DTYPE);
    if (!r) r = consumeToken(b, NORMAL3FTYPE);
    if (!r) r = consumeToken(b, NORMAL3HTYPE);
    if (!r) r = consumeToken(b, VECTOR3DTYPE);
    if (!r) r = consumeToken(b, VECTOR3FTYPE);
    if (!r) r = consumeToken(b, VECTOR3HTYPE);
    if (!r) r = consumeToken(b, COLOR3DTYPE);
    if (!r) r = consumeToken(b, COLOR3FTYPE);
    if (!r) r = consumeToken(b, COLOR3HTYPE);
    if (!r) r = consumeToken(b, COLOR4DTYPE);
    if (!r) r = consumeToken(b, COLOR4FTYPE);
    if (!r) r = consumeToken(b, COLOR4HTYPE);
    if (!r) r = consumeToken(b, FRAME4DTYPE);
    if (!r) r = consumeToken(b, TEXCOORD2HTYPE);
    if (!r) r = consumeToken(b, TEXCOORD2DTYPE);
    if (!r) r = consumeToken(b, TEXCOORD2FTYPE);
    if (!r) r = consumeToken(b, TEXCOORD3HTYPE);
    if (!r) r = consumeToken(b, TEXCOORD3DTYPE);
    if (!r) r = consumeToken(b, TEXCOORD3FTYPE);
    if (!r) r = consumeToken(b, TRANSFORMTYPE);
    if (!r) r = consumeToken(b, POINTINDEXTYPE);
    if (!r) r = consumeToken(b, EDGEINDEXTYPE);
    if (!r) r = consumeToken(b, FACEINDEXTYPE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BasicDataType | RoleDataType | dictionary
  public static boolean SingleAttributeType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SingleAttributeType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SINGLE_ATTRIBUTE_TYPE, "<single attribute type>");
    r = BasicDataType(b, l + 1);
    if (!r) r = RoleDataType(b, l + 1);
    if (!r) r = consumeToken(b, DICTIONARY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // doc | variantSet | kind | variants | customData | assetInfo
  public static boolean SpecialMetadataKey(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SpecialMetadataKey")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SPECIAL_METADATA_KEY, "<special metadata key>");
    r = consumeToken(b, DOC);
    if (!r) r = consumeToken(b, VARIANTSET);
    if (!r) r = consumeToken(b, KIND);
    if (!r) r = consumeToken(b, VARIANTS);
    if (!r) r = consumeToken(b, CUSTOMDATA);
    if (!r) r = consumeToken(b, ASSETINFO);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // def [Typename] PrimName | over PrimName | class [Typename] PrimName
  public static boolean Specifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Specifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SPECIFIER, "<specifier>");
    r = Specifier_0(b, l + 1);
    if (!r) r = Specifier_1(b, l + 1);
    if (!r) r = Specifier_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // def [Typename] PrimName
  private static boolean Specifier_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Specifier_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEF);
    r = r && Specifier_0_1(b, l + 1);
    r = r && PrimName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [Typename]
  private static boolean Specifier_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Specifier_0_1")) return false;
    Typename(b, l + 1);
    return true;
  }

  // over PrimName
  private static boolean Specifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Specifier_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OVER);
    r = r && PrimName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // class [Typename] PrimName
  private static boolean Specifier_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Specifier_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CLASS);
    r = r && Specifier_2_1(b, l + 1);
    r = r && PrimName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [Typename]
  private static boolean Specifier_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Specifier_2_1")) return false;
    Typename(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // leftbrace [!rightbrace FrameNumber colon Item (comma FrameNumber colon Item)* comma?] rightbrace | leftbrace rightbrace
  public static boolean TimeSample(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TimeSample")) return false;
    if (!nextTokenIs(b, LEFTBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TimeSample_0(b, l + 1);
    if (!r) r = parseTokens(b, 0, LEFTBRACE, RIGHTBRACE);
    exit_section_(b, m, TIME_SAMPLE, r);
    return r;
  }

  // leftbrace [!rightbrace FrameNumber colon Item (comma FrameNumber colon Item)* comma?] rightbrace
  private static boolean TimeSample_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TimeSample_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFTBRACE);
    r = r && TimeSample_0_1(b, l + 1);
    r = r && consumeToken(b, RIGHTBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [!rightbrace FrameNumber colon Item (comma FrameNumber colon Item)* comma?]
  private static boolean TimeSample_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TimeSample_0_1")) return false;
    TimeSample_0_1_0(b, l + 1);
    return true;
  }

  // !rightbrace FrameNumber colon Item (comma FrameNumber colon Item)* comma?
  private static boolean TimeSample_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TimeSample_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TimeSample_0_1_0_0(b, l + 1);
    r = r && FrameNumber(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Item(b, l + 1);
    r = r && TimeSample_0_1_0_4(b, l + 1);
    r = r && TimeSample_0_1_0_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !rightbrace
  private static boolean TimeSample_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TimeSample_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RIGHTBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (comma FrameNumber colon Item)*
  private static boolean TimeSample_0_1_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TimeSample_0_1_0_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!TimeSample_0_1_0_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TimeSample_0_1_0_4", c)) break;
    }
    return true;
  }

  // comma FrameNumber colon Item
  private static boolean TimeSample_0_1_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TimeSample_0_1_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && FrameNumber(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Item(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // comma?
  private static boolean TimeSample_0_1_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TimeSample_0_1_0_5")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // Identifier
  public static boolean Typename(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Typename")) return false;
    if (!nextTokenIs(b, ALPHA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Identifier(b, l + 1);
    exit_section_(b, m, TYPENAME, r);
    return r;
  }

  /* ********************************************************** */
  // leftbrace [!rightbrace VariantSetKey VariantSetItemBody (VariantSetKey VariantSetItemBody)*] rightbrace | leftbrace rightbrace
  public static boolean VariantSetBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariantSetBody")) return false;
    if (!nextTokenIs(b, LEFTBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariantSetBody_0(b, l + 1);
    if (!r) r = parseTokens(b, 0, LEFTBRACE, RIGHTBRACE);
    exit_section_(b, m, VARIANT_SET_BODY, r);
    return r;
  }

  // leftbrace [!rightbrace VariantSetKey VariantSetItemBody (VariantSetKey VariantSetItemBody)*] rightbrace
  private static boolean VariantSetBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariantSetBody_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFTBRACE);
    r = r && VariantSetBody_0_1(b, l + 1);
    r = r && consumeToken(b, RIGHTBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [!rightbrace VariantSetKey VariantSetItemBody (VariantSetKey VariantSetItemBody)*]
  private static boolean VariantSetBody_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariantSetBody_0_1")) return false;
    VariantSetBody_0_1_0(b, l + 1);
    return true;
  }

  // !rightbrace VariantSetKey VariantSetItemBody (VariantSetKey VariantSetItemBody)*
  private static boolean VariantSetBody_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariantSetBody_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariantSetBody_0_1_0_0(b, l + 1);
    r = r && VariantSetKey(b, l + 1);
    r = r && VariantSetItemBody(b, l + 1);
    r = r && VariantSetBody_0_1_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !rightbrace
  private static boolean VariantSetBody_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariantSetBody_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RIGHTBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (VariantSetKey VariantSetItemBody)*
  private static boolean VariantSetBody_0_1_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariantSetBody_0_1_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!VariantSetBody_0_1_0_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VariantSetBody_0_1_0_3", c)) break;
    }
    return true;
  }

  // VariantSetKey VariantSetItemBody
  private static boolean VariantSetBody_0_1_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariantSetBody_0_1_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariantSetKey(b, l + 1);
    r = r && VariantSetItemBody(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Metadata? (leftbrace [!rightbrace PrimSpec (PrimSpec)*] rightbrace | leftbrace rightbrace)
  public static boolean VariantSetItemBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariantSetItemBody")) return false;
    if (!nextTokenIs(b, "<variant set item body>", LEFTBRACE, LEFTPARENS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIANT_SET_ITEM_BODY, "<variant set item body>");
    r = VariantSetItemBody_0(b, l + 1);
    r = r && VariantSetItemBody_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Metadata?
  private static boolean VariantSetItemBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariantSetItemBody_0")) return false;
    Metadata(b, l + 1);
    return true;
  }

  // leftbrace [!rightbrace PrimSpec (PrimSpec)*] rightbrace | leftbrace rightbrace
  private static boolean VariantSetItemBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariantSetItemBody_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariantSetItemBody_1_0(b, l + 1);
    if (!r) r = parseTokens(b, 0, LEFTBRACE, RIGHTBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // leftbrace [!rightbrace PrimSpec (PrimSpec)*] rightbrace
  private static boolean VariantSetItemBody_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariantSetItemBody_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFTBRACE);
    r = r && VariantSetItemBody_1_0_1(b, l + 1);
    r = r && consumeToken(b, RIGHTBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [!rightbrace PrimSpec (PrimSpec)*]
  private static boolean VariantSetItemBody_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariantSetItemBody_1_0_1")) return false;
    VariantSetItemBody_1_0_1_0(b, l + 1);
    return true;
  }

  // !rightbrace PrimSpec (PrimSpec)*
  private static boolean VariantSetItemBody_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariantSetItemBody_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariantSetItemBody_1_0_1_0_0(b, l + 1);
    r = r && PrimSpec(b, l + 1);
    r = r && VariantSetItemBody_1_0_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !rightbrace
  private static boolean VariantSetItemBody_1_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariantSetItemBody_1_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RIGHTBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (PrimSpec)*
  private static boolean VariantSetItemBody_1_0_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariantSetItemBody_1_0_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!VariantSetItemBody_1_0_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VariantSetItemBody_1_0_1_0_2", c)) break;
    }
    return true;
  }

  // (PrimSpec)
  private static boolean VariantSetItemBody_1_0_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariantSetItemBody_1_0_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PrimSpec(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // string
  public static boolean VariantSetKey(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariantSetKey")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, VARIANT_SET_KEY, r);
    return r;
  }

  /* ********************************************************** */
  // leftparens [!rightparens Item? (comma Item)*] rightparens | leftparens rightparens
  public static boolean Vector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Vector")) return false;
    if (!nextTokenIs(b, LEFTPARENS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Vector_0(b, l + 1);
    if (!r) r = parseTokens(b, 0, LEFTPARENS, RIGHTPARENS);
    exit_section_(b, m, VECTOR, r);
    return r;
  }

  // leftparens [!rightparens Item? (comma Item)*] rightparens
  private static boolean Vector_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Vector_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFTPARENS);
    r = r && Vector_0_1(b, l + 1);
    r = r && consumeToken(b, RIGHTPARENS);
    exit_section_(b, m, null, r);
    return r;
  }

  // [!rightparens Item? (comma Item)*]
  private static boolean Vector_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Vector_0_1")) return false;
    Vector_0_1_0(b, l + 1);
    return true;
  }

  // !rightparens Item? (comma Item)*
  private static boolean Vector_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Vector_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Vector_0_1_0_0(b, l + 1);
    r = r && Vector_0_1_0_1(b, l + 1);
    r = r && Vector_0_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !rightparens
  private static boolean Vector_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Vector_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RIGHTPARENS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Item?
  private static boolean Vector_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Vector_0_1_0_1")) return false;
    Item(b, l + 1);
    return true;
  }

  // (comma Item)*
  private static boolean Vector_0_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Vector_0_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Vector_0_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Vector_0_1_0_2", c)) break;
    }
    return true;
  }

  // comma Item
  private static boolean Vector_0_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Vector_0_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Item(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // usdDeclaration Metadata? PrimSpec*
  static boolean usdFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usdFile")) return false;
    if (!nextTokenIs(b, USDDECLARATION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, USDDECLARATION);
    r = r && usdFile_1(b, l + 1);
    r = r && usdFile_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Metadata?
  private static boolean usdFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usdFile_1")) return false;
    Metadata(b, l + 1);
    return true;
  }

  // PrimSpec*
  private static boolean usdFile_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usdFile_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!PrimSpec(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "usdFile_2", c)) break;
    }
    return true;
  }

}
