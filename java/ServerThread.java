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
import java.util.concurrent.atomic.AtomicInteger;

public class ServerThread extends Thread {

    public static ConcurrentHashMap<String, AtomicInteger> petMap = new ConcurrentHashMap<>();

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
                    AtomicInteger max = new AtomicInteger(0);
                    String tempPet = "";
                    for (String pet : petMap.keySet()) {
                        for (String petCompare : petMap.keySet()) {
                            if(max.get() <= petMap.get(petCompare).get() && !set.contains(petCompare)){
                                max.set(petMap.get(petCompare).get());
                                tempPet = petCompare;
                            }
                        }
                        set.add(tempPet);
                        out.println(tempPet+":"+max.get());
                        max.set(0);
                    }
                    out.println("OK");
                }
                else if ("END".equals(str)) {
                    break;
                }
                else if ("GET:".equals(str.substring(0, 4))) {
                    String pet = str.substring(4);
                    synchronized (ServerThread.class) {
                        if (petMap.containsKey(pet)) {
                            petMap.get(pet).incrementAndGet();
                        } else {
                            petMap.put(pet, new AtomicInteger(1));
                        }
                        out.println("OK");
                    }
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
