package 练过的笔试题;

import java.util.Scanner;

public class 进制转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hex = sc.nextLine();
        hex = hex.substring(2);
        System.out.println(Integer.valueOf(hex, 16).toString());
    }
}
