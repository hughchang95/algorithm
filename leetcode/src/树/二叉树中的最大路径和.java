package 树;

import java.util.Stack;

public class 二叉树中的最大路径和 {
    int maxGain = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxGain;
    }

    public int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(maxGain(root.left),0);
        int right = Math.max(maxGain(root.right),0);

        int gain = left + right + root.val;
        maxGain = Math.max(gain, maxGain);

        return Math.max(left, right) + root.val;
    }
}
