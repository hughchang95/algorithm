package 数组;

public class 数组中缺失的数字 {
    //遍历
    public int missingNumber(int[] nums) {
        int i=0;
        for (int num : nums) {
            if (i==num)
                i++;
            else
                return i;
        }
        return nums.length;
    }

    //二分
    public int missingNumber2(int[] nums) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (nums[mid] != mid) high = mid;
            else low = mid + 1;
        }
        return low;
    }

}
