package arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        backTrack(res, list, 1, n, k);
        return res;
    }

    public void backTrack(List<List<Integer>> res, LinkedList<Integer> list, int m, int n, int k) {
        if (k == 0) {
            List<Integer> l = new ArrayList<>(list);
            res.add(l);
            return;
        }
        for (int i = m; i <= n; i++) {
            list.add(i);
            backTrack(res, list, i+1, n, k-i);
            list.removeLast();
        }
    }
}
