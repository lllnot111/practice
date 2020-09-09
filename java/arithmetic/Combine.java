package arithmetic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        backtrack(res, list, 1, n, k);
        return res;
    }

    public void backtrack(List<List<Integer>> res, LinkedList<Integer> list, int m, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = m; i <= n; i++) {
            list.add(i);
            backtrack(res, list, i+1, n, k-1);
            list.removeLast();
        }
    }
}
