package 动态规划.区间型DP;

public class 最长回文子串 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int maxLen = s.length();
        boolean[][] dp = new boolean[maxLen][maxLen];
        int maxBegin = 0;
        int maxEnd = 0;
        int max = 1;

        //状态转移
        for (int r = 1; r < maxLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(r) == s.charAt(l) && (dp[l + 1][r - 1] || r - l <= 2)) {
                    dp[l][r] = true;
                    if (r - l + 1 > max) {
                        maxBegin = l;
                        maxEnd = r;
                        max = r - l + 1;
                    }
                }
            }
        }
        return s.substring(maxBegin, maxEnd+1);
    }
}
