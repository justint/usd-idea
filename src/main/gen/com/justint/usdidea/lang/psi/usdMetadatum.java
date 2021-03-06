// This is a generated file. Not intended for manual editing.
package com.justint.usdidea.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface usdMetadatum extends PsiElement {

  @Nullable
  usdListEditAction getListEditAction();

  @NotNull
  usdMetadataKey getMetadataKey();

  @Nullable
  usdMetadataValue getMetadataValue();

  @NotNull
  String getName();

  boolean isDictionary();

  @NotNull
  ItemPresentation getPresentation();

}
