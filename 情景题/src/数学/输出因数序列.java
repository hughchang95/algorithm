package 数学;

import java.util.Scanner;

public class 输出因数序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long num = sc.nextLong();
            StringBuffer sb = new StringBuffer();
            while (num != 1) {
                for (int i = 2; i <= num; i++) {
                    if (num % i == 0) {
                        sb.append(i);
                        sb.append(" ");
                        num /= i;
                        break;
                    }
                }
            }
            System.out.println(sb);
        }
    }

}


