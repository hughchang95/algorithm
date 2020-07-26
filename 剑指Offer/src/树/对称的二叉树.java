package 树;

public class 对称的二叉树 {
    //特殊情况： 当树无节点（即 root == null 时），直接返回 true 。
    //递归终止条件：
    //当 L 和 R 同时越过叶子节点： 说明树从顶至底都满足对称二叉树规律，因此返回 true ；
    //当 L 或 R 中只有一个越过叶子节点： 树是不对称的，因此返回 false ；
    //当节点 L 值 不等于 节点 R 值： 此两节点不对称，因此树肯定是不对称的，因此返回 false ；
    //递推工作：
    //判断 L.left 和 R.right 是否对称，即开启下层递归 recur(L.left, R.right) ；
    //判断 L.right 和 R.left 是否对称，即开启下层递归 recur(L.right, R.left) ；
    //返回值： 两对节点都对称时，才是对称树，因此返回 recur(L.left, R.right) && recur(L.right, R.left) 。
    public boolean isSymmetric(TreeNode root) {
        return root == null || symmetric(root.left, root.right);
    }

    boolean symmetric(TreeNode L,TreeNode R){
        if (L==null&&R==null)
            return true;
        if (L==null||R==null||L.val!=R.val)
            return false;
        return symmetric(L.left,R.right)&&symmetric(L.right,R.left);
    }
}
