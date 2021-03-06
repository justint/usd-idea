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

public class usdPrimSpecImpl extends ASTWrapperPsiElement implements usdPrimSpec {

  public usdPrimSpecImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull usdVisitor visitor) {
    visitor.visitPrimSpec(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof usdVisitor) accept((usdVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public usdBody getBody() {
    return findChildByClass(usdBody.class);
  }

  @Override
  @Nullable
  public usdMetadata getMetadata() {
    return findChildByClass(usdMetadata.class);
  }

  @Override
  @NotNull
  public usdSpecifier getSpecifier() {
    return findNotNullChildByClass(usdSpecifier.class);
  }

  @Override
  @NotNull
  public String getPrimName() {
    return USDPsiImplUtil.getPrimName(this);
  }

  @Override
  @Nullable
  public String getPrimType() {
    return USDPsiImplUtil.getPrimType(this);
  }

  @Override
  @NotNull
  public String getPrimPath() {
    return USDPsiImplUtil.getPrimPath(this);
  }

  @Override
  @NotNull
  public String getName() {
    return USDPsiImplUtil.getName(this);
  }

  @Override
  @NotNull
  public ItemPresentation getPresentation() {
    return USDPsiImplUtil.getPresentation(this);
  }

}
