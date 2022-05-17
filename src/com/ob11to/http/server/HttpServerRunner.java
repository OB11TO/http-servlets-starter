package com.ob11to.http.server;

import com.sun.net.httpserver.HttpServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerRunner {
    private final ExecutorService pool;
    private final int port;
    private boolean flagStopped;

    public HttpServerRunner(int port, int poolSize) {
        this.port = port;
        this.pool = Executors.newFixedThreadPool(poolSize);
    }

    public void run() {
        try {
            var server = new ServerSocket(port);
            while (!flagStopped) {
                var socket = server.accept();
                System.out.println("Socket accepted");
                pool.submit(() -> processSocket(socket));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processSocket(Socket socket) {
        try (socket;
             var inputStream = new DataInputStream(socket.getInputStream());
             var outputStream = new DataOutputStream(socket.getOutputStream())) {


            Thread.sleep(10000L);
//            step 1: request
            System.out.println("Request: " + new String(inputStream.readNBytes(400))); // Считываем request от клиента и выводим

//            step 2: response
            var body = Files.readAllBytes(Path.of("resources", "example.html")); //готовим боди
            var headers = """   
                    HTTP/1.1 200 OK
                    content-type: text/html
                    content-length: %s
                    """.formatted(body.length).getBytes();  //готовим headers
            //отправка response
            outputStream.write(headers);
            outputStream.write(System.lineSeparator().getBytes());
            outputStream.write(body);

        } catch (IOException | InterruptedException e) {
            //TODO: 2/27/21 log error massage
            e.printStackTrace();
        }

    }

    public void setStopped(boolean stopped){
        this.flagStopped = stopped;
    }

}
