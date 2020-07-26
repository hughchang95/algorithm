package 见过的笔试题.度小满;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int[] cities = new int[N];
        for (int i = 0; i < N; i++) {
            cities[i] = sc.nextInt();
        }
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            int ce = checkEquals(cities, i);
            int cp = checkGapPlus(cities, i);
            int cd = checkGapDel(cities, i);
            if (ce != 0) {
                dp[i] = dp[ce] + A;
            } else {
                if (cp != 0 && cd != 0)
                    dp[i] = Math.min(dp[cp] + B + A, dp[cd] + C + A);
                else if (cp == 0) {
                    dp[i] = dp[cd] + C + A;
                } else {
                    dp[i] = dp[cp] + B + A;
                }
            }
        }
        System.out.println(dp[N]);

    }

    public static int checkEquals(int[] cities, int i) {
        for (int j = 0; j < cities.length; j++) {
            if (cities[j] == i) {
                return j + 1;
            }
        }
        return 0;
    }

    public static int checkGapPlus(int[] cities, int i) {
        for (int j = 0; j < cities.length; j++) {
            if (cities[j] == i - 1) {
                return j + 1;
            }
        }
        return 0;
    }

    public static int checkGapDel(int[] cities, int i) {
        for (int j = 0; j < cities.length; j++) {
            if (cities[j] == i + 1) {
                return j + 1;
            }
        }
        return 0;
    }
}
