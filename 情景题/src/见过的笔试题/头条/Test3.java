package 见过的笔试题.头条;

import java.util.Arrays;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(a);
        int sum = 0;
        for (int pb : b) {
            int price = pb;
            if (pb==0){
                continue;
            }
            if (a[0] > pb) {
                sum += price;
                continue;
            }
            for (int j = n - 1; j >= 0; j--) {
                if (a[j] <= price) {
                    price -= a[j];
                    break;
                }
            }
            sum += price;
        }
        System.out.println(sum);
    }
}
