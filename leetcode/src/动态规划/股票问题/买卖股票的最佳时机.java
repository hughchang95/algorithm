package 动态规划.股票问题;

public class 买卖股票的最佳时机 {
    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    max = Math.max(max, prices[j] - prices[i]);
                }
            }
        }
        return max;
    }

    public static int maxProfit2(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            }
            if (prices[i]-minValue>maxProfit){
                maxProfit=prices[i]-minValue;
            }
        }
        return maxProfit;
    }
}
