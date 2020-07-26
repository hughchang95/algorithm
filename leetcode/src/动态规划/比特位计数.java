package 动态规划;

public class 比特位计数 {
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[1];
        }
        int[] dp = new int[num];
        dp[0] = 0;
        dp[1] = 1;
        //0,1
        //0,1,1,2
        //0,1,1,2,1,2,2,3
        //用i记录当前开始更新的位置，用j来更新
        for (int i = 2; i < num; i = 2 * i) {
            for (int j = i; j < 2 * i; j++) {
                if (j > num) {
                    break;
                }
                dp[j] = dp[j - i] + 1;
            }
        }
        return dp;
    }
}
