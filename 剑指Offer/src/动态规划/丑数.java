package 动态规划;

public class 丑数 {
    public int nthUglyNumber(int n) {
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int i1 = dp[p2] * 2;
            int i2 = dp[p3] * 3;
            int i3 = dp[p5] * 5;
            dp[i] = Math.min(i1, Math.min(i2, i3));
            if (dp[i] == i1) p2++;
            if (dp[i] == i2) p3++;
            if (dp[i] == i3) p5++;
        }
        return dp[n - 1];
    }
}
