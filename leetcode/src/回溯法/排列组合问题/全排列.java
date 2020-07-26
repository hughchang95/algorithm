package 回溯法.排列组合问题;

import java.util.LinkedList;
import java.util.List;

public class 全排列 {
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track=new LinkedList<>();
        process(track,nums);
        return res;
    }

    public void process(List<Integer> track, int[] nums){
        if(track.size()==nums.length){
            res.add(new LinkedList<>(track));
        }
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
