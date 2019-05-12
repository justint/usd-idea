package com.justint.usdidea;

import com.intellij.lang.Language;

public class USDLanguage extends Language {

    public static final USDLanguage INSTANCE = new USDLanguage();

    private USDLanguage() {
        super("USD");
    }
}
