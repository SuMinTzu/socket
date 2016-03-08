package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientThread extends Thread
{
    private Socket socket; 
    public ClientThread(String ip, int port)
    {
        try
        {
            socket = new Socket(ip, port);
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
            if (socket != null) 
            {
                PrintStream writer = new PrintStream(socket.getOutputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
                writer.println("Hello!");
                writer.flush();
                System.out.println("Server:" + reader.readLine()); 
                socket.close();
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
