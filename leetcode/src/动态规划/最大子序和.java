package 动态规划;

public class 最大子序和 {
    public int maxSubArray(int[] nums) {
        if (nums.length==0){
            return Integer.MIN_VALUE;
        }
        //状态：以i为终点时的最大和
        int max = nums[0];
        int[] dp = new int[nums.length];
        //初始状态：
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
        //状态转移：max：前一节点+本节点，本节点
            dp[i] =Math.max(dp[i-1]+nums[i],nums[i]);
            max=Math.max(dp[i],max);
        }
        return max;
    }
}
