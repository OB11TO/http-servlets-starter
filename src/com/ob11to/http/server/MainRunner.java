package com.ob11to.http.server;

public class MainRunner {
    public static void main(String[] args) {
        var httpServerRunner = new HttpServerRunner(9000, 100);
        httpServerRunner.run();
    }
}
