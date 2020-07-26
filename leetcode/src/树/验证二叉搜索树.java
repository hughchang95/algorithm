package 树;

import 树.TreeNode;

import java.util.Stack;

public class 验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, int left, int right) {
        if (root == null) {
            return true;
        }
        int cur = root.val;
        if (cur < left || cur > right) {
            return false;
        }
        return isValid(root.left, left, cur) && isValid(root.right, cur, right);
    }

    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long pre = Long.MIN_VALUE;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                int cur = root.val;
                if (cur <= pre) {
                    return false;
                }
                pre = cur;
                root = root.right;
            }
        }
        return true;
    }
}
