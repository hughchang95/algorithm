package 数组;

import java.util.Arrays;

public class 扑克牌中的顺子 {
    //排序做法
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeros = 0;
        //最后一位在后续步骤中通过i+1比较
        for (int i = 0; i < 4; i++) {
            //为0，记录后跳出
            if (nums[i] == 0) {
                zeros++;
                continue;
            }
            //相同数字，返回false
            if (nums[i] == nums[i + 1])
                return false;
            //两个数间隔超过1时消耗0
            zeros -= nums[i + 1] - nums[i] - 1;
        }
        return zeros >= 0;
    }

    //不排序，监测差值
    public boolean isStraight2(int[] nums) {
        int[] bucket = new int[14];
        for (int num : nums) {
            if (num == 0)
                continue;
            if (bucket[num] == 1)
                return false;
            bucket[num] = 1;
        }
        int max = 0;
        int min = 0;
        for (int i = 1; i < 14; i++) {
            if (bucket[i] == 1) {
                min = i;
                break;
            }
        }
        for (int i = 13; i > 0; i--) {
            if (bucket[i] == 1) {
                max = i;
                break;
            }
        }
        return max - min <= 4;
    }
}
