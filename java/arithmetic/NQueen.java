package arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> d1 = new HashSet<>();
        Set<Integer> d2 = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        solveList(queens, n, 0, columns, d1, d2, res);
        return res;
    }

    public void solveList(int[] nQueens, int n, int lines, Set<Integer> columns, Set<Integer> d1, Set<Integer> d2, List<List<String>> res) {

        if (lines == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] cs = new char[n];
                Arrays.fill(cs, '.');
                cs[nQueens[i]] = 'Q';
                String s = new String(cs);
                list.add(s);
            }
            res.add(list);
        }
        for (int i = 0; i < n; i++) {
            if (columns.contains(i)) {
                continue;
            }
            if (d1.contains(lines - i)) {
                continue;
            }
            if (d2.contains(lines + i)) {
                continue;
            }
            nQueens[lines] = i;
            columns.add(i);
            d1.add(lines - i);
            d2.add(lines + i);
            solveList(nQueens, n, lines + 1, columns, d1, d2, res);
            nQueens[lines] = -1;
            columns.remove(i);
            d1.remove(lines - i);
            d2.remove(lines + i);
        }
    }
}
