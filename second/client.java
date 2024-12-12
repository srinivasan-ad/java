package second;

import java.io.*;

import java.net.*;

import java.util.Scanner;

 public class client {
public static void main(String[] args) throws Exception {
    client Client  = new client();
    Client.run();
}    
    public void run() throws Exception{
        Scanner sc=new Scanner(System.in);

		System.out.println("Enter no of frames to be sent:");

		int n=sc.nextInt();
        sc.close();
        Socket clienSocket = new Socket("localhost",9999);
        PrintStream clientPrintStream   =  new PrintStream(clienSocket.getOutputStream());
        for(int i = 1 ; i<= n ; ){
            if( i != n){
              
            
            System.out.println("Frame no "+i+ ") is sent");
            clientPrintStream.println(i);
            BufferedReader clientBuffer = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
            String message =clientBuffer.readLine();

			if(message != null  )

			{

				System.out.println("Acknowledgement was Received from receiver");

				

				Thread.sleep(4000);
                i++;

			}

			else

			{

			clientPrintStream.println(i);

			}   
        }
        else{
            clientPrintStream.println("exit !");
            System.out.println("Exit message sent to clientStrem !!");
            break;
        }
        }
        clientPrintStream.println("exit");
        clienSocket.close();
    }
}
