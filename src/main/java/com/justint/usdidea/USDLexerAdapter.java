package com.justint.usdidea;

import com.intellij.lexer.FlexAdapter;
import com.justint.usdidea.USDLexer;

import java.io.Reader;


public class USDLexerAdapter extends FlexAdapter {
    public USDLexerAdapter() {
        super(new USDLexer((Reader) null));
    }
}
