package 字符串;

public class _最长不含重复字符的子字符串 {
    //暴力解法，只记录是否出现过
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int begin = 0; begin < chars.length; begin++) {
            int[] bucket = new int[128];
            int end = begin;
            for (end = begin; end < chars.length; end++) {
                if (bucket[chars[end]] == 0) {
                    bucket[chars[end]] = 1;
                } else {
                    break;
                }
            }
            res = res > (end - begin) ? res : end - begin;
        }
        return res;
    }

    //记录上次出现的位置
    public static int lengthOfLongestSubstring2(String s) {
        int[] index = new int[128];
        for (int i : index) {
            i = -1;
        }
        int cur = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int last = index[c];
            if (last < 0 || i - last > cur) {
                cur++;
            } else {
                cur = i - last;
            }
            res = res > cur ? res : cur;
            index[c] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("ddddd"));
    }
}
