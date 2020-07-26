package 字符串;

public class 外观数组 {
    public String countAndSay(int n) {
        String s = "1";
        //i表示遍历层数
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            //j是对当前s的遍历指针
            for (int j = 0; j < s.length(); ) {
                //对于j指向的字母，求相同字符的指针：滑动窗口的思想
                int k = j;
                while (k < s.length() && s.charAt(k) == s.charAt(j)) {
                    k++;
                }
                sb.append(k - j);
                sb.append(s.charAt(j));
                //此时的k指向不等的第一个数
                j = k;
            }
            s = sb.toString();
        }
        return s;
    }
}
