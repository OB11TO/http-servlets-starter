package com.ob11to.http.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;

import java.net.Socket;
import java.util.Scanner;

public class SocketRunner {
    public static void main(String[] args) throws IOException {
//        http - 80
//        https - 443
//        tcp
        var inetAddresses = Inet4Address.getByName("localhost");  //создание IP
        try (var socket = new Socket(inetAddresses, 7777);  // сокет (IP address, порт)
             var outputStream = new DataOutputStream(socket.getOutputStream()); //создает поток ввода
             var inputStream = new DataInputStream(socket.getInputStream());
             var scanner = new Scanner(System.in)) { //создает поток вывода

            while (scanner.hasNextLine()) {
                var send = scanner.nextLine();
                outputStream.writeUTF(send);
                var responseServer = inputStream.readUTF();
                if("stop".equals(responseServer)){
                    break;
                }else {
                    System.out.println("Server: " + responseServer);
                }
            }
        }

    }
}
