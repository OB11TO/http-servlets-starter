package com.ob11to.http.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class HttpClientExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        var httpClient = HttpClient.newBuilder()  // http client для работы с http
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://google.com")) //создаем первый запрос GET
                .GET()
                .build();

        HttpRequest request2 = HttpRequest.newBuilder(URI.create("https://google.com")) //создаем второй запрос POST
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of("path","to","file")))
                .header("content-type", "text/plain")
                .build();



        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString()); //отправляем первый запрос и сразу возвращается ответ

        System.out.println(response.body());
        System.out.println(response.headers().toString());
    }
}
