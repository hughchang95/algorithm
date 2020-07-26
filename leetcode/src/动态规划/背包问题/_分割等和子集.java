package 动态规划.背包问题;

public class _分割等和子集 {
    public boolean canPartition(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;

        //状态表示：[当前坐标][当前值]=是否恰好装满
        boolean[][] dp = new boolean[length][target + 1];

        //初始化：第一个数如果小于目标，则可以装满容积为其大小的背包
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= target; j++) {
                //容积不够，自然不用加入

                dp[i][j] = dp[i - 1][j];

                //恰好等于当前容量，直接返回true
                if (nums[i] == j) {
                    dp[i][j] = true;
                }
                //一般情况：不加入满足或加入后满足
                //不加入：当前已经满足
                //加入：找到可以满足j - nums[i]的数
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[length - 1][target];

    }
}
