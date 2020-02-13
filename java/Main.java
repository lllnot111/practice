
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999, 1000);

            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    ServerThread serverThread = new ServerThread(socket);
                    serverThread.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
