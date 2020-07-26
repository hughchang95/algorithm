package 树;

import java.util.HashMap;

public class 二叉树的直径 {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getDiameter(root);
        return ans;
    }

    public int getDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //获得左子树最大深度
        int l = getDiameter(root.left);
        //获得右子树最大深度
        int r = getDiameter(root.right);
        //更新记录
        ans = Math.max(l + r, ans);
        //返回最大深度
        return Math.max(l, r) + 1;
    }
}
