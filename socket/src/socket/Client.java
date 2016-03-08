package socket;

public class Client
{
    public static void main(String[] argv)
    {
        new ClientThread("127.0.0.1", 1234).start();
    }
}