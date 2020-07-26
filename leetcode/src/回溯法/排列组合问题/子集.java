package 回溯法.排列组合问题;

import java.util.LinkedList;
import java.util.List;

public class 子集 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> track = new LinkedList<>();
        process(0, track, nums);
        return res;
    }

    public void process(int start, List<Integer> track, int[] nums) {
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            process(i + 1, track, nums);
            track.remove(track.size() - 1);
        }
    }
}
