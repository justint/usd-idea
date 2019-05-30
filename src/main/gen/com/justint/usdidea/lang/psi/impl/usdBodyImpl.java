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

public class usdBodyImpl extends ASTWrapperPsiElement implements usdBody {

  public usdBodyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull usdVisitor visitor) {
    visitor.visitBody(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof usdVisitor) accept((usdVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<usdPrimSpec> getPrimSpecList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, usdPrimSpec.class);
  }

  @Override
  @NotNull
  public List<usdPropertySpec> getPropertySpecList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, usdPropertySpec.class);
  }

}
