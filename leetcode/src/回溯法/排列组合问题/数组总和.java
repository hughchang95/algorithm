package 回溯法.排列组合问题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 数组总和 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return res;
        }
        Arrays.sort(candidates);
        find(0, new LinkedList<>(), candidates, target);
        return res;
    }

    public void find(int cur, LinkedList<Integer> trace, int[] candidates, int target) {
        if (0 > target) {
            return;
        }
        if (0 == target) {
            res.add(new LinkedList<>(trace));
            return;
        }
        //从0开始会重复，此处保持选自己和后续数字
        for (int i = cur; i < candidates.length; i++) {
            if (target < candidates[i]) {
                break;
            }
            trace.add(candidates[i]);
            //可以使用重复的数字，但是不会重复
            find(i, trace, candidates, target - candidates[i]);
            trace.remove(trace.size() - 1);
        }
    }
}
