package 树;

public class 打家劫舍3 {
    //偷不偷都可以，但是偷了下一层就不能偷
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int money = root.val;
        if (root.left != null) {
            money += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            money += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(money, rob(root.left) + rob(root.right));
    }

    public int rob2(TreeNode root) {
        int[] res=doRob(root);
        return Math.max(res[0],res[1]);
    }

    public int[] doRob(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] res = new int[2];

        int[] left = doRob(root.left);
        int[] right = doRob(root.right);
        //本次不偷，可以获得上次偷到的最大值
        res[0] = Math.max(left[1], left[0]) + Math.max(right[1], right[0]);
        //本次偷，可以获得本次的值
        res[1] = left[0] + right[0] + root.val;

        return res;
    }
}
