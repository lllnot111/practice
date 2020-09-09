package arithmetic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        combination(res, list, candidates, 0, target);

        return res;
    }

    public void combination(List<List<Integer>> res, LinkedList<Integer> list, int[] candidates, int n, int target) {
        if(target == 0) {
            List<Integer> l = new ArrayList<>(list);
            res.add(l);
            return;
        }
        for (int i = n;i < candidates.length;i++) {
            list.add(candidates[i]);
            if(target-candidates[i]>=0) {
                combination(res, list, candidates, i, target - candidates[i]);
            }
            list.removeLast();
        }
    }
}
