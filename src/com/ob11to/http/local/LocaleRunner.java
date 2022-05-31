package com.ob11to.http.local;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleRunner {
    public static void main(String[] args) {
        Locale locale = new Locale("ru", "RU");
        System.out.println(locale);
        System.out.println(locale.getLanguage());
        System.out.println(locale.getCountry());
        System.out.println(locale.getDisplayCountry());
        System.out.println(Locale.getDefault());

        var translations = ResourceBundle.getBundle("translations",locale);
        System.out.println(translations.getString("page.login.password"));
    }
}
