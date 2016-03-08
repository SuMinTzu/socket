package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerThread extends Thread
{
    private ServerSocket serverSocket; 
    private Socket socket;
    public ServerThread(int port)
    {
        try
        {
            serverSocket = new ServerSocket(port);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void run()
    {
        try
        {
            System.out.println("waiting for connect¡K!");
            socket = serverSocket.accept();
            System.out.println("connecting finishing!"); 
            serverSocket.close(); 
            PrintStream writer; 
            BufferedReader reader;            
            writer = new PrintStream(socket.getOutputStream()); 
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
            System.out.println("Client: " + reader.readLine());           
            writer.println("Hello Client!"); 
            writer.flush(); 
            socket.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
