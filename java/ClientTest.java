import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ClientTest {

    public static void main(String[] args) throws Exception{

        InetAddress address = InetAddress.getByName(null);
        System.out.println("address = " + address);
        List<ClientThread> clientThreads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Socket socket = new Socket(address, 9999);
            ClientThread clientThread = new ClientThread(socket);
            clientThread.start();
            clientThreads.add(clientThread);
        }
        for (int i = 0; i < clientThreads.size(); i++) {
            clientThreads.get(i).join();
        }
        Socket socket = new Socket(address, 9999);
        System.out.println("Socket = " + socket);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        InputStream is = socket.getInputStream();

        System.out.println("count total");
        out.println("List");
        String str = "";
        do{
            str = in.readLine();
            System.out.println(str);
            if (!"OK".equals(str)) {
                String[] splits = str.split(":");
                switch (splits[0]) {
                    case "dog":
                        System.out.println("40".equals(splits[1]));
                        break;
                    case "cat":
                        System.out.println("30".equals(splits[1]));
                        break;
                    case "parrot":
                        System.out.println("20".equals(splits[1]));
                        break;

                }
            }
        }
        while (!"OK".equals(str));
        out.println("END");
        socket.close();
    }
}