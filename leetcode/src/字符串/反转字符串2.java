package 字符串;

public class 反转字符串2 {
    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            while (r < s.length()-1 && r < i + k-1) {
                r++;
            }
            int mark = r;
            if (flag) {
                while (l < r) {
                    swap(chars, l++, r--);
                }
            }
            flag = !flag;
            i = mark;
        }
        return new String(chars);
    }

    public static void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("a", 2));
    }
}
