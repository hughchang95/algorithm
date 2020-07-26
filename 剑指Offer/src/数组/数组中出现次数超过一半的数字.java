package 数组;

import java.util.Arrays;
import java.util.HashMap;

public class 数组中出现次数超过一半的数字 {
    //哈希思路
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count ;
            if (map.get(nums[i]) == null)
                count = 0;
            else
                count = map.get(nums[i]);
            map.put(nums[i], ++count);
            if (count >= nums.length / 2 + 1)
                return nums[i];
        }
        return 0;
    }

    //排序后一定在中间
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    //如果数组中有一个数字出现的次数超过该数组长度的一半，也就是说它出现的次数比所有数字出现的次数总和还要多，对此可以维护一个数字和次数
    //如果该数字和保存的数字相同，count++
    //如果不同，count--
    //如果count = 0， 将当前遍历数字保存
    //最终得到的保存的数字就是求得的次数超半的数字
    public static int majorityElement3(int[] nums) {
        int count=1;
        int target=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (target==nums[i])
                count++;
            else {
                count--;
                if (count==0){
                    target=nums[i];
                    count=1;
                }
            }
        }
        return target;
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement2(a));
    }
}
