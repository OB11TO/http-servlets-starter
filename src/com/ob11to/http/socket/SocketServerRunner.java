package com.ob11to.http.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServerRunner {
    public static void main(String[] args) throws IOException {
        try (var serverSocket = new ServerSocket(7777);
             var socket = serverSocket.accept();
             var outputStream = new DataOutputStream(socket.getOutputStream());
             var inputStream = new DataInputStream(socket.getInputStream());
             var scanner = new Scanner(System.in)) {

            var readSendClient = inputStream.readUTF();
            while (!"stop".equals(readSendClient)) {
                System.out.println("Client: " + readSendClient);
                var responseServer = scanner.nextLine();
                outputStream.writeUTF(responseServer);
                readSendClient = inputStream.readUTF();
            }
        }
    }
}

