package 字符串;

public class 反转字符串中的单词3 {
    //反转每个单词
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ) {
            if (chars[i] == ' ') {
                i++;
            } else {
                int l = i;
                int r = i;
                while (r < chars.length && chars[r] != ' ') {
                    r++;
                }
                int mark = r--;
                while (l < r) {
                    swap(chars, l++, r--);
                }
                i = mark;
            }
        }
        return new String(chars);
    }

    public void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
