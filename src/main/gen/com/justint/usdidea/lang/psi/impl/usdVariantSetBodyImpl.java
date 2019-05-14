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

public class usdVariantSetBodyImpl extends ASTWrapperPsiElement implements usdVariantSetBody {

  public usdVariantSetBodyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull usdVisitor visitor) {
    visitor.visitVariantSetBody(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof usdVisitor) accept((usdVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<usdVariantSetItemBody> getVariantSetItemBodyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, usdVariantSetItemBody.class);
  }

  @Override
  @NotNull
  public List<usdVariantSetKey> getVariantSetKeyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, usdVariantSetKey.class);
  }

}
