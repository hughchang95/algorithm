package 动态规划;

public class 剪绳子 {
    //动态规划
    public int cuttingRope(int n) {
        if (n < 2) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    //贪心法，拥有3就拥有一切
    public int cuttingRope2(int n) {
        if (n <= 3)
            return n - 1;
        int x = n / 3, y = n % 3;
        if (y == 0) {
            return (int) Math.pow(3, x);
        }
        if (y == 1) {
            return (int) Math.pow(3, (x - 1)) * 4;
        }
        return (int) Math.pow(3, x) * 2;
    }
}
