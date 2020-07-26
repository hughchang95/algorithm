package 树;

public class 二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //找到返回找到的节点，没找到返回null
        if (root == null || root == p || root == q) {
            return root;
        }
        //是一个普通节点，开始找
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //左边没有在右边
        if (left == null)
            return right;
        //右边没有在左边
        if (right == null)
            return left;
        //一边一个，返回当前节点
        return root;
    }
}
