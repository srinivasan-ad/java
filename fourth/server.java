package fourth;

import java.io.*;
import java.net.*;
import java.util.*;

public class  server {
    public static void main(String[] args) {
        DatagramSocket skt = null;
        Scanner sc = new Scanner(System.in);
        try {
            skt = new DatagramSocket(2400); // Bind the server to port 2400
            byte[] buffer = new byte[1000]; // Buffer to store incoming data

            while (true) {
                // Receive a request from the client
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                skt.receive(request);
                System.out.println("Client message received!");

                // Read server's reply message from the console
                System.out.print("Enter reply message: ");
                String message = sc.nextLine();

                // Convert message to bytes and send to client
                byte[] sendMsg = message.getBytes();
                DatagramPacket reply = new DatagramPacket(
                    sendMsg, sendMsg.length, request.getAddress(), request.getPort()
                );
                skt.send(reply); // Send reply to the client
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (skt != null) {
                skt.close(); // Close the socket
            }
        }
    }
}
