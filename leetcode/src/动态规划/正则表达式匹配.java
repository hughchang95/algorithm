package 动态规划;

public class 正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //状态：s长为i，p长为j时是否匹配
        dp[0][0] = true;
        for (int i = 2; i <= p.length(); i++) {
            //初始化s为空，p不为空时的情况
            //只有符合 X* 开头的情况，且后续为X****或X*X*X*的情况，才能匹配，注意i代表p字符串长度
            //p长度为1时永远是false
            dp[0][i] = p.charAt(i - 1) == '*' && dp[0][i - 2];
        }
        //此时都为长度
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                //所有操作基于指针
                char sc = s.charAt(i - 1);
                char pc = s.charAt(j - 1);
                if (sc == pc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (pc == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (pc == '*') {
                        if (j >= 2) {
                            //指向了前一个数
                            char past = p.charAt(j - 2);
                            if (past == sc || past == '.') {
                                //*代表多个或一个元素
                                dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                            }
                            //消除两个元素
                            dp[i][j] = dp[i][j] || dp[i][j - 2];
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }

            }
        }
        return dp[s.length()][p.length()];
    }
}
