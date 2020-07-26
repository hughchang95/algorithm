package 动态规划.条件判断DP;

public class 最长有效括号 {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2;
                    if (i - 2 > 0)
                        dp[i] = dp[i] + dp[i - 2];
                }
                if (s.charAt(i - 1) == ')') {
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if (i - dp[i - 1] - 2 >= 0)
                            dp[i] += dp[i - dp[i - 1] - 2];
                    }
                }
            }

            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
