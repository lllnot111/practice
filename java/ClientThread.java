import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {

    private Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            System.out.println("Socket = " + socket);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            InputStream is = socket.getInputStream();


            for (int i = 0; i < Math.random() % 3; i++) {
                out.println("GET:dog");
                String str = in.readLine();
                System.out.println(str);
            }
            for (int i = 0; i < Math.random() % 3; i++) {
                out.println("GET:cat");
                String str = in.readLine();
                System.out.println(str);
            }
            for (int i = 0; i < Math.random() % 3; i++) {
                out.println("GET:parrot");
                String str = in.readLine();
                System.out.println(str);
            }
            out.println("List");
            String str = "";
            do{
                str = in.readLine();
                System.out.println(str);
            }
            while (!"OK".equals(str));
            out.println("END");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
