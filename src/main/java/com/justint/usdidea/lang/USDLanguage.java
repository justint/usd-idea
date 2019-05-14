package com.justint.usdidea.lang;

import com.intellij.lang.Language;

public class USDLanguage extends Language {

    public static final USDLanguage INSTANCE = new USDLanguage();

    private USDLanguage() {
        super("USD");
    }
}
