package 动态规划.背包问题.零一背包;

import java.util.Scanner;

public class 零一背包问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        //体积
        int[] v = new int[N + 1];
        //价值
        int[] w = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        sc.close();

        //状态：[物品][容量]=最大价值
        //状态转移：是否装入物品

//        int[][] dp = new int[N + 1][V + 1];
//        dp[0][0] = 0;
//        for (int i = 1; i <= N; i++) {
//            for (int j = 0; j <= V; j++) {
//                if (v[i] > j) {
//                    dp[i][j] = dp[i - 1][j];
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + w[i]);
//                }
//            }
//        }
//        System.out.println(dp[N][V]);

        int[] dp = new int[V + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            //滚动数组
            for (int j = V; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        System.out.println(dp[V]);

    }
}
