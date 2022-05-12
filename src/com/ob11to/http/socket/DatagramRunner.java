package com.ob11to.http.socket;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class DatagramRunner { //клиент
    public static void main(String[] args) throws IOException {

        var localhost = Inet4Address.getByName("localhost");

        try (var datagramSocket = new DatagramSocket()) {
//            -------> [buffer] <------
            byte[] buffer = "Hello UPD Client".getBytes(StandardCharsets.UTF_8); // buffer
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, localhost, 8888);

            datagramSocket.send(datagramPacket); //оправили пакет
        }
    }
}
