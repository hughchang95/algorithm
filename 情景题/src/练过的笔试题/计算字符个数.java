package 练过的笔试题;

import java.util.Scanner;

//写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
public class 计算字符个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String target = sc.nextLine();
        String str1 = str.toLowerCase();
        String str2 = str.toUpperCase();

        int[] bucket1 = new int[128];
        int[] bucket2 = new int[128];
        for (int i = 0; i < str.length(); i++) {
            bucket1[str1.charAt(i)]++;
            bucket2[str2.charAt(i)]++;
        }

        char c = target.charAt(0);
        if (c >= 'A' && c <= 'Z') {
            System.out.println(bucket2[c]);
        } else {
            System.out.println(bucket1[c]);
        }
    }
}
