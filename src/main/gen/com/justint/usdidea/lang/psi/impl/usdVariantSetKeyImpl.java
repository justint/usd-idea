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

public class usdVariantSetKeyImpl extends ASTWrapperPsiElement implements usdVariantSetKey {

  public usdVariantSetKeyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull usdVisitor visitor) {
    visitor.visitVariantSetKey(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof usdVisitor) accept((usdVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getString() {
    return findNotNullChildByType(STRING);
  }

  @Override
  public usdVariantSetItemBody getBody() {
    return USDPsiImplUtil.getBody(this);
  }

  @Override
  public String getName() {
    return USDPsiImplUtil.getName(this);
  }

  @Override
  public ItemPresentation getPresentation() {
    return USDPsiImplUtil.getPresentation(this);
  }

}
