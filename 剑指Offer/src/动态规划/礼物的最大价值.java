package 动态规划;

public class 礼物的最大价值 {
    //DP,原地修改状态表
    public int maxValue(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        for (int i = 1; i < width; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < height; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                grid[i][j] = grid[i][j] + Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[height - 1][width - 1];
    }
}
