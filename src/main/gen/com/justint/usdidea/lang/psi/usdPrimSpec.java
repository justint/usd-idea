// This is a generated file. Not intended for manual editing.
package com.justint.usdidea.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface usdPrimSpec extends USDBreadcrumbItem {

  @Nullable
  usdBody getBody();

  @Nullable
  usdMetadata getMetadata();

  @NotNull
  usdSpecifier getSpecifier();

  @NotNull
  String getPrimName();

  @Nullable
  String getPrimType();

  @NotNull
  String getPrimPath();

  @NotNull
  String getName();

  @NotNull
  ItemPresentation getPresentation();

}
