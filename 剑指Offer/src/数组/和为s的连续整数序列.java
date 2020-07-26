package 数组;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 和为s的连续整数序列 {

    //暴力
    public static int[][] findContinuousSequence(int target) {
        int i;
        int j;
        List<int[]> list = new ArrayList<>();
        for (i = 1; i < target / 2 + 1; i++) {
            int sum = 0;
            int[] res = null;
            for (j = i; j < target / 2 + 2; j++) {
                sum += j;
                if (sum > target)
                    break;
                if (sum == target) {
                    res = new int[j - i + 1];
                    int count = 0;
                    for (int k = i; k <= j; k++) {
                        res[count] = k;
                        count++;
                    }
                    list.add(res);
                }
            }

        }
        return list.toArray(new int[list.size()][]);
    }

    //滑动窗口优化
    public int[][] findContinuousSequence2(int target) {
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j-i];
                for (int k = i; k < j; k++) {
                    arr[k-i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }


    public static void main(String[] args) {
        int[][] res = findContinuousSequence(9);
    }
}


