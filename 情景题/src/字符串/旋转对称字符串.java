package 字符串;

import java.util.Scanner;

//招行卡中心
//对称数问题
//9669不对称
//69对称
public class 旋转对称字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            System.out.println(isMirror(s));
            t--;
        }
    }

    private static String isMirror(String s) {
        StringBuffer sb = new StringBuffer(s);
        String reverse = sb.reverse().toString();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1' && reverse.charAt(i) == '1') {
                count++;
            }
            if (s.charAt(i) == '2' && reverse.charAt(i) == '5') {
                count++;
            }
            if (s.charAt(i) == '3' && reverse.charAt(i) == '8') {
                count++;
            }
            if (s.charAt(i) == '4' && reverse.charAt(i) == '7') {
                count++;
            }
            if (s.charAt(i) == '5' && reverse.charAt(i) == '2') {
                count++;
            }
            if (s.charAt(i) == '6' && reverse.charAt(i) == '9') {
                count++;
            }
            if (s.charAt(i) == '7' && reverse.charAt(i) == '4') {
                count++;
            }
            if (s.charAt(i) == '8' && reverse.charAt(i) == '3') {
                count++;
            }
            if (s.charAt(i) == '9' && reverse.charAt(i) == '6') {
                count++;
            }
        }
        if (count == s.length()) {
            return "YES";
        }
        return "NO";
    }

}
