package 回溯法.排列组合问题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 子集2 {
    class Solution {
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            backTrack(0, new LinkedList<>(), nums);
            return res;
        }

        public void backTrack(int start, List<Integer> track, int[] nums) {
            res.add(new LinkedList<>(track));
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1])
                    continue;
                track.add(nums[i]);
                backTrack(i + 1, track, nums);
                track.remove(track.size() - 1);
            }
        }
    }
}
