// This is a generated file. Not intended for manual editing.
package com.justint.usdidea.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.justint.usdidea.lang.psi.USDTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.justint.usdidea.lang.psi.*;

public class usdItemImpl extends ASTWrapperPsiElement implements usdItem {

  public usdItemImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull usdVisitor visitor) {
    visitor.visitItem(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof usdVisitor) accept((usdVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public usdArray getArray() {
    return findChildByClass(usdArray.class);
  }

  @Override
  @Nullable
  public usdDict getDict() {
    return findChildByClass(usdDict.class);
  }

  @Override
  @Nullable
  public usdInterpolatedArray getInterpolatedArray() {
    return findChildByClass(usdInterpolatedArray.class);
  }

  @Override
  @Nullable
  public usdTimeSample getTimeSample() {
    return findChildByClass(usdTimeSample.class);
  }

  @Override
  @Nullable
  public usdVector getVector() {
    return findChildByClass(usdVector.class);
  }

  @Override
  @Nullable
  public PsiElement getAssetReference() {
    return findChildByType(ASSETREFERENCE);
  }

  @Override
  @Nullable
  public PsiElement getFloatnumber() {
    return findChildByType(FLOATNUMBER);
  }

  @Override
  @Nullable
  public PsiElement getNumber() {
    return findChildByType(NUMBER);
  }

  @Override
  @Nullable
  public PsiElement getPathReference() {
    return findChildByType(PATHREFERENCE);
  }

  @Override
  @Nullable
  public PsiElement getString() {
    return findChildByType(STRING);
  }

}
