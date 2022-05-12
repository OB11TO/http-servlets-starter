package com.ob11to.http.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerRunner {
    public static void main(String[] args) throws IOException {
        try (var serverSocket = new ServerSocket(7777);
             var socket = serverSocket.accept();
             var outputStream = new DataOutputStream(socket.getOutputStream());
             var inputStream = new DataInputStream(socket.getInputStream())) {

            var readUTF = inputStream.readUTF();
            outputStream.writeUTF("Hello! I am Server");
            System.out.println(readUTF);

        }
    }
}
