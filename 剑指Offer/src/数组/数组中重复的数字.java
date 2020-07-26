package 数组;

import java.util.Arrays;
import java.util.HashSet;

public class 数组中重复的数字 {
    //利用set特性
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = nums[i];
            if (!set.add(result))
                return result;
        }
        return result;
    }

    //基础.排序
    public int findRepeatNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1])
                return nums[i];
        }
        return 0;
    }

    //在原数组进行桶排序，减治思想
    public int findRepeatNumber3(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //1.位置与值相同，i++
            //2.只要位置与值不同即进行交换，目标是位置与值相等
            while (nums[i]!=i){
                //4.过程中，（值）与（其所对应的位置）（的值）相等，返回
                if (nums[i]==nums[nums[i]])
                    return nums[i];
                //3.交换出一个位置与值相等的情况
                int temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return 0;
    }

}
