// This is a generated file. Not intended for manual editing.
package com.justint.usdidea.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface usdMetadata extends PsiElement {

  @NotNull
  List<usdListEditAction> getListEditActionList();

  @NotNull
  List<usdMetadataComment> getMetadataCommentList();

  @NotNull
  List<usdMetadataKey> getMetadataKeyList();

  @NotNull
  List<usdMetadataValue> getMetadataValueList();

}
