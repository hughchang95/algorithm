package 数学;

public class 整数反转 {
    //字符串方法
    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        String s = String.valueOf(x);
        StringBuffer sb = new StringBuffer(s);
        boolean flag = false;
        if (sb.charAt(0) == '-') {
            sb.deleteCharAt(0);
            flag = true;
        }
        sb.reverse();
        if (sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        if (flag) {
            sb.insert(0, '-');
        }
        long num = Long.valueOf(sb.toString());
        if (num > Integer.MIN_VALUE && num < Integer.MAX_VALUE)
            return (int) num;
        return 0;
    }

    //直接反转
    public static int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            int cur = x % 10;
            if (res > (Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && cur > 7)) {
                return 0;
            }
            if (res < (Integer.MIN_VALUE / 10) || (res == Integer.MIN_VALUE / 10 && cur < -8)) {
                return 0;
            }
            res += res * 10 + cur;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
