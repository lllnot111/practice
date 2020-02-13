import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ServerThread extends Thread {

    public static ConcurrentHashMap<String, Integer> petMap = new ConcurrentHashMap<>();

    Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            while (true) {
                String str = in.readLine();
                if ("List".equals(str)) {
                    Set set = new HashSet();
                    int max = 0;
                    String tempPet = "";
                    for (String pet : petMap.keySet()) {
                        for (String petCompare : petMap.keySet()) {
                            if(max <= petMap.get(petCompare) && !set.contains(petCompare)){
                                max = petMap.get(petCompare);
                                tempPet = petCompare;
                            }
                        }
                        set.add(tempPet);
                        out.println(tempPet+":"+max);
                        max = 0;
                    }
                    out.println("OK");
                }
                else if ("END".equals(str)) {
                    break;
                }
                else if ("GET:".equals(str.substring(0, 4))) {
                    String pet = str.substring(4);
                    if (petMap.containsKey(pet)) {
                        petMap.put(pet, petMap.get(pet) + 1);

                    } else {
                        petMap.put(pet, 1);
                    }
                    out.println("OK");
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
