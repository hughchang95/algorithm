package 见过的笔试题.头条;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
            //do something
            if (judge(a, b)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }

    public static boolean judge(int[] a, int[] b) {
        int i = 0;
        boolean flag = true;
        while (i < a.length - 1) {
            if (b[i] - a[i] == 0) {
                i++;
                continue;
            }
            if (flag) {
                if (b[i + 1] - a[i + 1] == b[i] - a[i]) {
                    i++;
                    continue;
                } else if (b[i + 1] - a[i + 1] == 0) {
                    i++;
                    flag=false;
                    continue;
                }
            }
            return false;
        }
        return true;
    }

}
