package 回溯法.排列组合问题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 树型回溯重点总结：
 * 1.进入下一步时需要判断：一般需要搞清楚树的下一层范围
 * 2.结果集去重条件判断：一般采用排序后比较相邻元素的方法去重
 */
public class _排列和子集问题总结 {
    /**
     * 全排列问题：
     * 1.再选择时可以选择任意位置
     * 2.不能重复选择自己
     */
    class 全排列 {
        //构造解集容器
        List<List<Integer>> res=new LinkedList<>();
        public List<List<Integer>> permute(int[] nums) {
            LinkedList<Integer> track=new LinkedList<>();
            process(track,nums);
            return res;
        }

        public void process(List<Integer> track,int[] nums){
            if(track.size()==nums.length){
                res.add(new LinkedList<>(track));
            }
            //每次选择的区间是一致的，除了自己都要遍历
            for(int i=0;i<nums.length;i++){
                if(track.contains(nums[i])){
                    continue;
                }
                track.add(nums[i]);
                process(track,nums);
                track.remove(track.size()-1);
            }
        }
    }

    /**
     * 子集1：
     * 1.不自带重复元素
     * 2.结果不能重复
     * 防止重复的办法：每次都在i+1上寻找
     *
     */
    class 子集 {
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

    /**
     * 子集2：
     * 1.自带重复元素
     * 2.结果不能重复
     * 自带重复元素去重：排序后比较相邻元素，重复则跳过迭代
     * 防止重复的办法：每次都在i+1上寻找
     * ——————————————————————————————————
     * 升级：数组总和2：
     * 1.元素本身可以无限取用：进入下一步时从自身开始
     * 2.结果不能重复：迭代区间从自身开始而不是从零开始
     * ——————————————————————————————————
     * 升级：数组总和2：
     * 1.自带重复元素：排序后判重
     * 2.结果不能重复：在i+1上寻找下一步
     * ——————————————————————————————————
     */
    class 子集2 {
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
}
