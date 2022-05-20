package com.ob11to.http.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {

    private static final Properties PROPERTIES = new Properties(); //МАП

    private PropertiesUtil(){

    }

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) { //открываем поток
            PROPERTIES.load(inputStream); //загружаем данные из потока
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }
}
