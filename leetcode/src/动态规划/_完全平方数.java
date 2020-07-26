package 动态规划;

public class _完全平方数 {
    public int numSquares(int n) {
        //状态：当前数字：次数
        //状态转移：
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
