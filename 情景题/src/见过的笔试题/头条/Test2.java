package 见过的笔试题.头条;

import java.util.Scanner;
import java.util.Stack;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ary = new int[n];
        for (int i = 0; i < n; i++) {
            ary[i] = sc.nextInt();
        }
        System.out.println(getResult(ary));
    }

    public static int getResult(int[] ary) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = ary.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(ary[i]);
                continue;
            }
            Integer top = stack.peek();
            if (top < ary[i]) {
                int times;
                times = (ary[i] - 1) / top;
                res += times;
                stack.push(ary[i] / (times + 1));
            } else {
                stack.push(ary[i]);
            }
        }
        return res;
    }
}
