package 树;

public class 二叉搜索树的第k大节点 {
    int count, result = -1;

    public int kthLargest(TreeNode root, int k) {
        int count = k;
        kthLargest(root);
        return result;
    }

    void kthLargest(TreeNode root) {
        if (root == null)
            return;
        kthLargest(root.right);
        if (count == 1) {
            result = root.val;
            count--;
            return;
        }
        count--;
        kthLargest(root.left);
    }
}
