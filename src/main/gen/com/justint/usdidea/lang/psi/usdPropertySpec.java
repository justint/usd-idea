// This is a generated file. Not intended for manual editing.
package com.justint.usdidea.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.tree.IElementType;

public interface usdPropertySpec extends PsiElement {

  @Nullable
  usdAttributeProperty getAttributeProperty();

  @Nullable
  usdMetadata getMetadata();

  @Nullable
  usdRelationshipProperty getRelationshipProperty();

  @NotNull
  String getPropertyName();

  @Nullable
  IElementType getPropertyType();

  //WARNING: getPropertyValueType(...) is skipped
  //matching getPropertyValueType(usdPropertySpec, ...)
  //methods are not found in USDPsiImplUtil

  @NotNull
  String getName();

  @NotNull
  ItemPresentation getPresentation();

}
