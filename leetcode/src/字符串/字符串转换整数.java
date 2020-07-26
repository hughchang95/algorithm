package 字符串;

public class 字符串转换整数 {
    public static int myAtoi(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i == str.length()) {
            return 0;
        }
        boolean isNegative = false;
        if (str.charAt(i) == '-') {
            isNegative = true;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        } else if (!Character.isDigit(str.charAt(i))) {
            return 0;
        }
        int res = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int d = str.charAt(i) - '0';
            if (res > (Integer.MAX_VALUE - d) / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + d;
            i++;
        }
        return isNegative ? -res : res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("1"));
    }
}
