package 数组;

public class 和为s的两个数字 {
    //暴力
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = nums[i];
                    res[1] = nums[j];
                }
            }
        }
        return res;
    }

    //前后双指针
    public int[] twoSum2(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int sum;
        int[] res = new int[2];
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                res[0] = nums[i];
                res[1] = nums[j];
                break;
            }
            if (sum < target)
                i++;
            else {
                j--;
            }
        }
        return res;

    }
}
