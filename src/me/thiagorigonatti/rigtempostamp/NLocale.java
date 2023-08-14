package me.thiagorigonatti.rigtempostamp;

import java.util.Locale;

public class NLocale {

    public static final NLocale PT_BR = new NLocale(new Locale("pt", "BR"));
    public static final NLocale US = new NLocale(Locale.US);
    final Locale locale;

    NLocale(Locale locale) {
        this.locale = locale;
    }

}
