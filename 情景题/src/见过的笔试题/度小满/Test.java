package 见过的笔试题.度小满;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[][] board = new int[n][m];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                board[i - 1][j - 1] = (i * j) % 10;
            }
        }
        int sum = 0;
        for (int i = 0; i <= n - a; i++) {
            for (int j = 0; j <= m - b; j++) {
                int max = 0;
                for (int k = i; k < i + a; k++) {
                    for (int l = j; l < j + b; l++) {
                        if (board[k][l] > max) max = board[k][l];
                    }
                }
                sum += max;
            }
        }
        System.out.println(sum);

    }
}
