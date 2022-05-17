package com.ob11to.http.server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class HttpClientRunner {
    public static void main(String[] args) throws IOException, InterruptedException {
        var httpClient = HttpClient //создаем клиента
                .newBuilder()
                .version(HttpClient.Version.HTTP_1_1).build();


        //создаем request
        var httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9000"))
                .header("content-type", "application/json") //тип того, что будем передавать серверу
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of("resources", "first.json")))
                .build();


        //отправляем request и сразу возвращаем response
        var httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println(httpResponse.headers());
        System.out.println("\n");
        System.out.println(httpResponse.body());
    }
}
