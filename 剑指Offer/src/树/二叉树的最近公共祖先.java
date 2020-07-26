package 树;

public class 二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //若root中只包含p则返回p
        //若root中只包含q则返回q
        //若root中不包含p也不包含q则返回NULL
        //若root中同时包含p和q，则返回root（此时root为最近公共祖先）
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }
}
