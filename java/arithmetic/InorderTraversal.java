package arithmetic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode temp = root;
        deque.add(root);
        while(!deque.isEmpty()) {
            if (temp.left != null) {
                deque.add(temp.left);
                TreeNode t = temp;
                temp = temp.left;
                t.left = null;
            } else {
                temp = deque.removeLast();
                res.add(temp.val);
                if(temp.right != null) {
                    deque.add(temp.right);
                    TreeNode t = temp;
                    temp = temp.right;
                    t.right = null;
                }
            }
        }
        return res;
    }
}
