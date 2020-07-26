package 树;

public class 平衡二叉树 {
    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return flag;
        height(root);
        return flag;
    }

    //后序遍历
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        return 1 + Math.max(left, right);
    }

}
