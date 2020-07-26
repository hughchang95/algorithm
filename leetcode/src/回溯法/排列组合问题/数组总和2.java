package 回溯法.排列组合问题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 数组总和2 {
    List<List<Integer>> lists = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        find(0, new LinkedList<>(), candidates, target);
        return lists;
    }

    public void find(int start, List<Integer> list, int[] candidates, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            lists.add(new LinkedList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                //提前终止
                if (target < candidates[i]) {
                    break;
                }
                //排序+下面这行：保证解集中不出现重复的组合
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                find(i + 1, list, candidates, target - candidates[i]);
                list.remove(list.size() - 1);
            }
        }

    }
}
