package 动态规划;

public class n个骰子的点数 {
    public double[] twoSum(int n) {
        int[][] dp = new int[n + 1][n * 6 + 1];
        for (int cur = 1; cur <= 6; cur++) {
            dp[1][cur] = 1;
        }
        for (int num = 2; num <= n; num++) {
            for (int sum = num; sum <= num * 6; sum++) {
                for (int cur = 1; cur <= 6; cur++) {
                    if (sum - cur <= 0)
                        break;
                    dp[num][sum] += dp[num - 1][sum - cur];
                }
            }
        }
        double[] res = new double[n * 5 + 1];
        double total = Math.pow(6, n);
        for (int i = n; i <= n * 6; i++) {
            res[i - n] = (double) dp[n][i] / total;
        }
        return res;
    }

    public double[] twoSum2(int n) {
        int[] dp = new int[n * 6 + 1];
        double[] res = new double[n * 5 + 1];
        double total = Math.pow(6, n);
        for (int cur = 1; cur <= 6; cur++) {
            dp[cur] = 1;
            res[cur - 1] = 1.0 / 6;
        }
        for (int num = 2; num <= n; num++) {
            for (int sum = n * 6; sum >= 1; sum--) {
                int temp = 0;
                for (int cur = 1; cur <= 6; cur++) {
                    if (sum - cur <= 0)
                        break;
                    temp += dp[sum - cur];
                }
                dp[sum] = temp;
                if (num == n && sum >= n)
                    res[sum - num] = (double) dp[sum] / total;
            }
        }
        return res;
    }
}

