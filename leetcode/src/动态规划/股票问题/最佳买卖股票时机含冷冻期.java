package 动态规划.股票问题;

public class 最佳买卖股票时机含冷冻期 {
    public int maxProfit(int[] prices) {
        int[][] state = new int[prices.length][2];
        state[0][0] = 0;
        state[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            state[i][0] = Math.max(state[i - 1][0], state[i - 1][1] + prices[i]);
            //对特殊情况的处理
            if (i < 2) {
                state[i][1] = Math.max(state[i - 1][1], -prices[i]);
            }
            state[i][1] = Math.max(state[i - 1][1], state[i - 1][0] - prices[i]);
        }
        return state[prices.length - 1][0];
    }
}
