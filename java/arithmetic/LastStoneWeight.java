package arithmetic;

import java.util.Arrays;
import java.util.LinkedList;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        LinkedList<Integer> list = new LinkedList<>();
        for(int i : stones){
            list.add(i);
        }

        int x = 0;
        int y = 0;
        do {
            for(int i = 0; i< stones.length; i++) {

            }
        }
        while(y>0);
        return 0;
    }

}
