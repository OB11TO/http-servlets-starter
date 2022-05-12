package com.ob11to.http.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DatagramServerSocket {
    public static void main(String[] args) throws IOException {
        try (var datagramSocket = new DatagramSocket(8888)) {
            byte[] buffer = new byte[512];
            var datagramPacket = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(datagramPacket);

            System.out.println(new String(buffer));
        }
    }
}
