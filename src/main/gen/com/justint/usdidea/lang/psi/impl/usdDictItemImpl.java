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
import com.intellij.navigation.ItemPresentation;

public class usdDictItemImpl extends ASTWrapperPsiElement implements usdDictItem {

  public usdDictItemImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull usdVisitor visitor) {
    visitor.visitDictItem(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof usdVisitor) accept((usdVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public usdDictKey getDictKey() {
    return findNotNullChildByClass(usdDictKey.class);
  }

  @Override
  @NotNull
  public usdDictValue getDictValue() {
    return findNotNullChildByClass(usdDictValue.class);
  }

  @Override
  @NotNull
  public String getName() {
    return USDPsiImplUtil.getName(this);
  }

  @Override
  @NotNull
  public usdAttributeType getType() {
    return USDPsiImplUtil.getType(this);
  }

  @Override
  public boolean isDictionary() {
    return USDPsiImplUtil.isDictionary(this);
  }

  @Override
  @NotNull
  public ItemPresentation getPresentation() {
    return USDPsiImplUtil.getPresentation(this);
  }

}
