package socket;

public class Server
{
    public static void main(String[] argv)
    {
        new ServerThread(1234).start();
    }
}