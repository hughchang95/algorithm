package 字符串;

public class 翻转单词顺序 {
    public static String reverseWords(String s) {
        s = s.trim();
        String[] strings = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].equals(""))
                continue;
            res.append(strings[i]).append(" ");
        }
        String result=new String(res);
        return result.trim();
    }

    public static void main(String[] args) {
        String s = "a good   example.";
        System.out.println(reverseWords(s));
    }
}
