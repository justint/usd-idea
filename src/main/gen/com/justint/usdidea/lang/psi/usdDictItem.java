// This is a generated file. Not intended for manual editing.
package com.justint.usdidea.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface usdDictItem extends USDBreadcrumbItem {

  @NotNull
  usdDictKey getDictKey();

  @NotNull
  usdDictValue getDictValue();

  @NotNull
  String getName();

  @NotNull
  usdAttributeType getType();

  boolean isDictionary();

  @NotNull
  ItemPresentation getPresentation();

}
