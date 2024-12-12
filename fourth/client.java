package fourth;

import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) {
        DatagramSocket skt;
        try {
            skt = new DatagramSocket(); // Create a client socket

            // Message to send to the server
            String msg = "Hello Server, this is a text message!";
            byte[] b = msg.getBytes();

            // Specify the server address and port
            InetAddress host = InetAddress.getByName("127.0.0.1"); // Localhost
            int serverSocket = 2400;

            // Create a request packet and send it to the server
            DatagramPacket request = new DatagramPacket(b, b.length, host, serverSocket);
            skt.send(request);

            // Receive the server's reply
            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            skt.receive(reply);

            // Print the reply message
            System.out.println("Client received: " + new String(reply.getData(), 0, reply.getLength()));
            skt.close(); // Close the socket
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
