package 动态规划;

import java.util.LinkedList;
import java.util.List;

public class 杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new LinkedList<>();
        }
        int[] dp = new int[numRows];
        List<List<Integer>> res = new LinkedList<>();
        dp[0] = 1;
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        res.add(list1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new LinkedList<>();
            list.add(1);
            for (int j = 1; j < numRows; j++) {
                dp[j] = dp[j - 1] + dp[j];
                if (dp[j] != 0) {
                    list.add(dp[j]);
                }
            }
            res.add(list);
        }
        return res;
    }
}
