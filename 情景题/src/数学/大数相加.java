package 数学;

import java.util.Scanner;

public class 大数相加 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.nextLine();
        String num2 = sc.nextLine();
        boolean flag1 = false;
        boolean flag2 = false;
        if (num1.charAt(0) == '-') {
            num1 = num1.substring(1);
            flag1 = true;
        }
        if (num2.charAt(0) == '-') {
            num2 = num2.substring(1);
            flag2 = true;
        }
        if (!flag1 && !flag2) {
            System.out.println(add(num1, num2));
        }
        if (flag1 && flag2) {
            System.out.println("-" + add(num1, num2));
        }

    }

    private static String add(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int temp = 0;
        int carry = 0;
        StringBuffer res = new StringBuffer();
        while (i >= 0 && j >= 0) {
            int i1 = num1.charAt(i) - '0';
            int i2 = num2.charAt(j) - '0';
            temp = i1 + i2 + carry;
            carry = temp / 10;
            res.append(temp % 10);
            i--;
            j--;
        }
        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}
