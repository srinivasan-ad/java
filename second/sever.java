package second;
import java.io.*;
import java.net.*;

public class sever {
    public static void main(String [] args) throws Exception  {
           sever Server = new  sever();
           Server.run();
    }
    public void run()  {
        try{
            String payload = "This is a message to test check :)" , exitString = "exiting !" ;
            ServerSocket socketNum  = new ServerSocket(9999);
            Socket socketAccept = socketNum.accept();
            BufferedReader socketBuffer = new BufferedReader(new InputStreamReader(socketAccept.getInputStream()));
            PrintStream socketPrintStream = new PrintStream(socketAccept.getOutputStream());
            int i = 0;
            while(payload.compareTo(exitString) != 0) {
             Thread.sleep(1000);
             payload = socketBuffer.readLine();
             if (payload == null) {
                System.out.println("Empty message received, exiting.......");
                System.out.println("ALL FRAMES WERE RECEIVED SUCCESSFULLY");
                socketNum.close();
                socketAccept.close();
                break;
            }
             if(payload.compareTo(exitString) == 0)
         {
             break;
         }   
    
         
             System.out.println(i +")Frame : " + payload + " Recieved");
             i++;
             Thread.sleep(500);
             socketPrintStream.println("Recieved :)");
               
           
     
             
             
         
             }
           }
           catch (IOException | InterruptedException e) {
            System.out.println("Buffer is empty exiting.......");
           }
           }
        }

