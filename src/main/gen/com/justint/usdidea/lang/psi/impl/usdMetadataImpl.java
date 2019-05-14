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

public class usdMetadataImpl extends ASTWrapperPsiElement implements usdMetadata {

  public usdMetadataImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull usdVisitor visitor) {
    visitor.visitMetadata(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof usdVisitor) accept((usdVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<usdListEditAction> getListEditActionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, usdListEditAction.class);
  }

  @Override
  @NotNull
  public List<usdMetadataComment> getMetadataCommentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, usdMetadataComment.class);
  }

  @Override
  @NotNull
  public List<usdMetadataKey> getMetadataKeyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, usdMetadataKey.class);
  }

  @Override
  @NotNull
  public List<usdMetadataValue> getMetadataValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, usdMetadataValue.class);
  }

}
