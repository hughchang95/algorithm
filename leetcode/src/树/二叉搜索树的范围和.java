package 树;

import java.util.Stack;

/**
 * 二叉搜索树中L到R直接数值的和
 */
public class 二叉搜索树的范围和 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.val >= L && node.val <= R) {
                    res += node.val;
                }
                if (node.val >= L) {
                    stack.push(node.left);
                }
                if (node.val <= R) {
                    stack.push(node.right);
                }
            }

        }
        return res;

    }

}
