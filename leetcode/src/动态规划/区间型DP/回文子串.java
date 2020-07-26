package 动态规划.区间型DP;

public class 回文子串 {
    public int countSubstrings(String s) {
        //状态：[左指针][右指针]=是否回文
        //状态转移：
        //  满足回文条件（左值=右值）：前一状态+1+1
        //      右-左=1：+1，右-左=2：+1+1
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int count = s.length();
        for (int r = 1; r < length; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (dp[l + 1][r - 1] || r - l <= 2)) {
                    dp[l][r] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
