package arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        backTrack(res, list, 0, candidates, target);
        return res;
    }

    public void backTrack(List<List<Integer>> res, LinkedList<Integer> list, int n, int[] candidates, int target) {
        if(target == 0) {
            List<Integer> l = new ArrayList<>(list);
            res.add(l);
            return;
        }

        for (int i = n; i < candidates.length; i++) {
            if (i > n && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            if(target >= candidates[i]) {
                backTrack(res, list, i+1, candidates, target - candidates[i]);
            }
            list.removeLast();
        }
    }
}
