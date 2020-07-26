package 链表.环状列表;

public class 寻找重复数 {
    public int findDuplicate(int[] nums) {
        int[] bucket = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
            if (bucket[i] > 1) {
                return i;
            }
        }
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] > 1) {
                return i;
            }
        }
        return 0;
    }

    //循环检测
    public int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        int mark = nums[0];
        while (slow != mark) {
            slow = nums[slow];
            mark = nums[mark];
        }
        return mark;
    }
}
