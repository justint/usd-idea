package com.justint.usdidea.lang.lexer;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;


public class USDLexerAdapter extends FlexAdapter {
    public USDLexerAdapter() {
        super(new USDLexer((Reader) null));
    }
}
