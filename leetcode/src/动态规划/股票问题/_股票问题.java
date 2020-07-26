package 动态规划.股票问题;

public class _股票问题 {
    /**
     * 股票问题可以用状态机解决
     * <p>
     * 用三维数组保存股票问题的状态:
     * 天数n(0-n)|操作次数k(0-k)|持有状态(0,1)=利润
     * int[][][] state=new int[n][k][2];
     * <p>
     * 状态转移方程为：
     * 现在没持有=max（昨天没持有今天不变，昨天持有今天卖了）
     * state[n][k][0]=Math.max(state[n-1][k][0],state[n-1][k][1]+prices[i]);
     * 现在持有=max（昨天没持有今天买了，昨天持有今天不变） 注意买时需要消耗k
     * state[n][k][1]=Math.max(state[n-1][k][1],state[n-1][k-1][0]-prices[i]);
     * <p>
     * 初始状态为：
     * dp[-1][k][0] = 0
     * 解释：因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润当然是 0 。
     * dp[-1][k][1] = -infinity
     * 解释：还没开始的时候，是不可能持有股票的，用负无穷表示这种不可能。
     * dp[i][0][0] = 0
     * 解释：因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0 。
     * dp[i][0][1] = -infinity
     * 解释：不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能。
     */

    //k=1的情况
    public static int maxProfit(int[] prices) {
        int[][] state = new int[prices.length][2];
        state[0][0] = 0;
        state[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            state[i][0] = Math.max(state[i - 1][0], state[i - 1][1] + prices[i]);
            state[i][1] = Math.max(state[i - 1][1], -prices[i]);
        }
        return state[prices.length - 1][0];
    }

    //k=infinity的情况
    public int maxProfit2(int[] prices) {
        int[][] state = new int[prices.length][2];
        state[0][0] = 0;
        state[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            state[i][0] = Math.max(state[i - 1][0], state[i - 1][1] + prices[i]);
            state[i][1] = Math.max(state[i - 1][1], state[i - 1][0] - prices[i]);
        }
        return state[prices.length - 1][0];
    }

    //k=2的情况
//    state[n][k][0]=Math.max(state[n-1][k][0],state[n-1][k][1]+prices[i]);
//    state[n][k][1]=Math.max(state[n-1][k][1],state[n-1][k-1][0]-prices[i]);
//
//    dp[-1][k][0] = 0
//    dp[-1][k][1] = -infinity
//    dp[i][0][0] = 0
//    dp[i][0][1] = -infinity
    public int maxProfit3(int[] prices) {
        int k = 2;
        int[][][] state = new int[prices.length][k + 1][2];

        for (int i = 0; i < prices.length; i++) {
            for (k = 2; k >= 1; k--) {
                if (i == 0) {
                    state[i][k][0] = 0;
                    state[i][k][1] = -prices[0];
                    continue;
                }
                state[i][k][0] = Math.max(state[i - 1][k][0], state[i - 1][k][1] + prices[i]);
                state[i][k][1] = Math.max(state[i - 1][k][1], state[i - 1][k - 1][0] - prices[i]);
            }
        }
        return state[prices.length - 1][2][0];
    }
}
