package com.ob11to.http.util;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public final class ConnectionManager {

    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";

    private ConnectionManager() {
    }

    @SneakyThrows
    public static Connection get(){
        return DriverManager.getConnection(
                PropertiesUtil.get(URL_KEY),
                PropertiesUtil.get(USER_KEY),
                PropertiesUtil.get(PASSWORD_KEY)
        );
    }
}
