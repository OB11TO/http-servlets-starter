package com.ob11to.http.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;

import java.net.Socket;

public class SocketRunner {
    public static void main(String[] args) throws IOException {
//        http - 80
//        https - 443
//        tcp
        var inetAddresses = Inet4Address.getByName("localhost");  //создание IP
        try (var socket = new Socket(inetAddresses, 7777);  // сокет (IP address, порт)
            var outputStream = new DataOutputStream(socket.getOutputStream()); //создает поток ввода
            var inputStream = new DataInputStream(socket.getInputStream())) { //создает поток вывода

            outputStream.writeUTF("Hello! I am Client"); //Записывает строку в базовый выходной поток
           // var response = inputStream.readAllBytes(); //Считывает все оставшиеся байты из входного потока.
            var readUTF = inputStream.readUTF();
            System.out.println(readUTF);

        }

    }
}
