package 见过的笔试题.华为;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        int[] nums = new int[10];
        for (char c : chars) {
            if (Character.isDigit(c)) {
                nums[c - '0']++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (num > 0) {
                sb.append(i);
                num--;
            }
        }
        System.out.println(sb);
    }
}