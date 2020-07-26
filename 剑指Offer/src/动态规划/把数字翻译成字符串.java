package 动态规划;

public class 把数字翻译成字符串 {
    public int translateNum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int[] dp = new int[chars.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= chars.length; i++) {
            if (chars[i - 2] > '0' && (chars[i - 2] - '0') * 10 + (chars[i - 1] - '0') <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else
                dp[i] = dp[i - 1];
        }
        return dp[chars.length];
    }
}
