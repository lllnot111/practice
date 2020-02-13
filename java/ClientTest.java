import java.net.InetAddress;
import java.net.Socket;


public class ClientTest {

    public static void main(String[] args) throws Exception{

        InetAddress address = InetAddress.getByName(null);
        System.out.println("address = " + address);
        for (int i = 0; i < 10; i++) {
            Socket socket = new Socket(address, 9999);
            new ClientThread(socket).start();
        }
    }
}