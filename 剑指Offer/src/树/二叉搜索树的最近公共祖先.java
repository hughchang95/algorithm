package 树;


public class 二叉搜索树的最近公共祖先 {
    //利用二叉搜索树的性质，分布在同一边就去子树查找，否则根节点就是公共节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
