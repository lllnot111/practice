
import arithmetic.BitwiseComplement;
import arithmetic.CombinationSum2;
import arithmetic.Combine;
import arithmetic.InorderTraversal;
import arithmetic.TreeNode;

public class Main {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        System.out.println(new InorderTraversal().inorderTraversal(treeNode));
    }
}
