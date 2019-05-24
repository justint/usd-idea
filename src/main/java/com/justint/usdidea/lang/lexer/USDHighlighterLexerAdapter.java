package com.justint.usdidea.lang.lexer;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class USDHighlighterLexerAdapter extends FlexAdapter {
    public USDHighlighterLexerAdapter() {
        super(new USDHighlighterLexer((Reader) null));
    }
}
