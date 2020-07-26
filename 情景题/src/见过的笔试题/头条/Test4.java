package 见过的笔试题.头条;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] ary = new int[n];
            for (int j = 0; j < n; j++) {
                ary[j] = sc.nextInt();
            }
            //do
            int[] res = getResult(ary);
            for (int j = 0; j < n; j++) {
                System.out.println(res[i]);
            }
        }
    }

    public static int[] getResult(int[] ary) {
        int[] res = new int[ary.length];
        for (int i = 0; i < ary.length; i++) {
            int count = 0;
            int j = i;
            int temp = ary[j];
            while (j < ary.length - 1) {
                if (temp > ary[j + 1]) {
                    count++;
                }
                j++;
            }
            j = i;
            temp = ary[j];
            while (j > 0) {
                if (temp > ary[j - 1])
                    count++;
                j--;
            }
            res[i] = count;
        }
        return res;
    }
}
