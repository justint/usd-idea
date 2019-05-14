// This is a generated file. Not intended for manual editing.
package com.justint.usdidea.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface usdItem extends PsiElement {

  @Nullable
  usdArray getArray();

  @Nullable
  usdDict getDict();

  @Nullable
  usdInterpolatedArray getInterpolatedArray();

  @Nullable
  usdTimeSample getTimeSample();

  @Nullable
  usdVector getVector();

  @Nullable
  PsiElement getAssetReference();

  @Nullable
  PsiElement getFloatnumber();

  @Nullable
  PsiElement getNumber();

  @Nullable
  PsiElement getPathReference();

  @Nullable
  PsiElement getString();

}
