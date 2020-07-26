package 动态规划;

public class 不同路径 {
    public int uniquePaths(int m, int n) {
        //状态：坐标=当前路径数
        //状态转移：左边路径数+上边路径数
        if (m==0||n==0){
            return 1;
        }
        int[][] dp = new int[m + 1][n + 1];
//        for (int i = 0; i < m; i++) {
//            dp[i][0]=0;
//        }
//        for (int i = 0; i < n; i++) {
//            dp[0][i]=0;
//        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
