import java.net.InetAddress;
import java.net.Socket;


public class ClientTest {

    public static void main(String[] args) throws Exception{

        //服务器端信息，address和8080；后台连接服务器，还会绑定客户端
        InetAddress address = InetAddress.getByName(null);
        System.out.println("address = " + address);
        for (int i = 0; i < 10; i++) {
            Socket socket = new Socket(address, 9999);
            new ClientThread(socket).start();
        }
    }
}