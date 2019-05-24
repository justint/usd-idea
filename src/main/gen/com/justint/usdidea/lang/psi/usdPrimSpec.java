// This is a generated file. Not intended for manual editing.
package com.justint.usdidea.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface usdPrimSpec extends PsiElement {

  @NotNull
  usdBody getBody();

  @Nullable
  usdMetadata getMetadata();

  @NotNull
  usdSpecifier getSpecifier();

  String getPrimName();

  String getPrimType();

  String getName();

  ItemPresentation getPresentation();

}
