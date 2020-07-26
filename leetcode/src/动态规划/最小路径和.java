package 动态规划;

public class 最小路径和 {
    public int minPathSum(int[][] grid) {
        if (grid.length==0){
            return 0;
        }
        //状态：[位置]=当前最小值
        //状态变化：min（上方，左方）+value
        //初始条件：
        int height = grid.length;
        int width = grid[0].length;
        int[][] dp = new int[height + 1][width + 1];
        for (int i = 0; i <= height; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= width; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = grid[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
                }
            }
        }
        return dp[height][width];
    }
}
