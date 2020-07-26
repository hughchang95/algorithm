package 字符串;

public class 第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0)
            return ' ';
        int[] count = new int[26];
        //用一个类似hash的数组来存储字符出现的次数
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i)]++;
        //根据String顺序遍历数组并访问hash记录
        for (int i = 0; i < s.length(); i++)
            if (count[s.charAt(i)] == 1)
                return s.charAt(i);
        return ' ';
    }
}
