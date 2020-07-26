package 数组.双指针;

public class 多数元素 {
    //投票算法
    public int majorityElement(int[] nums) {
        //标记
        int res = 0;
        //票数
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            //平票时选择新候选人，第一次时会初始化标记
            if (count == 0) res = nums[i];
            //出现当前标记的数据则票数增加，否则减少
            if (nums[i] == res) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }
}
