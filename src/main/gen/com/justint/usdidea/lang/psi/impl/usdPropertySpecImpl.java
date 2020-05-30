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
import com.intellij.psi.tree.IElementType;

public class usdPropertySpecImpl extends ASTWrapperPsiElement implements usdPropertySpec {

  public usdPropertySpecImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull usdVisitor visitor) {
    visitor.visitPropertySpec(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof usdVisitor) accept((usdVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public usdAttributeProperty getAttributeProperty() {
    return findChildByClass(usdAttributeProperty.class);
  }

  @Override
  @Nullable
  public usdMetadata getMetadata() {
    return findChildByClass(usdMetadata.class);
  }

  @Override
  @Nullable
  public usdRelationshipProperty getRelationshipProperty() {
    return findChildByClass(usdRelationshipProperty.class);
  }

  @Override
  @NotNull
  public String getPropertyName() {
    return USDPsiImplUtil.getPropertyName(this);
  }

  @Override
  @Nullable
  public IElementType getPropertyType() {
    return USDPsiImplUtil.getPropertyType(this);
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
