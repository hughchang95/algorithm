package 树;

/**
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 */
public class 最小高度树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return locate(nums, 0, nums.length - 1);
    }

    //二分法，由于数组已经排序，直接插入即可
    public TreeNode locate(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = locate(nums, left, mid - 1);
        root.right = locate(nums, mid + 1, right);
        return root;
    }
}
