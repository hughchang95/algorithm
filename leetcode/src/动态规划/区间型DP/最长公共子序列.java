package 动态规划.区间型DP;

public class 最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        int i = text1.length();
        int j = text2.length();
        int[][] dp = new int[i + 1][j + 1];
        for (int k = 0; k <= i; k++) {
            dp[k][0] = 0;
        }
        for (int k = 0; k <= j; k++) {
            dp[0][k] = 0;
        }
        for (int k = 1; k <= i; k++) {
            for (int l = 1; l <= j; l++) {
                if (text1.charAt(k - 1) == text2.charAt(l - 1))
                    dp[k][l] = dp[k - 1][l - 1] + 1;
                else
                    dp[k][l] = Math.max(dp[k - 1][l], dp[k][l - 1]);

            }
        }
        return dp[i][j];
    }
}
