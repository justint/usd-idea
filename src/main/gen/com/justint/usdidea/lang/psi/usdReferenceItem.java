// This is a generated file. Not intended for manual editing.
package com.justint.usdidea.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface usdReferenceItem extends USDNamedElement {

  @Nullable
  PsiElement getAssetReference();

  @Nullable
  PsiElement getPathReference();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

  @NotNull
  String getDescriptionName();

}
