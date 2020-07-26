package 数组;

public class 数组中数字出现的次数 {
    //位运算，分组
    public int[] singleNumbers(int[] nums) {
        int res = 0, a = 0, b = 0;
        //整个数组的异或
        for (int num : nums) {
            res ^= num;
        }
        //找到第一个不为0的位置
        int m = 1;
        while ((res & m) == 0) {
            m <<= 1;
        }
        //针对该位置分组
        for (int num : nums) {
            if ((m & num) == 0)
                a ^= num;
            b ^= num;
        }
        return new int[]{a, b};
    }
}
