package 数组;

import java.util.LinkedList;

public class 滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return new int[0];
        }
        //定义结果数组
        int[] res = new int[len - k + 1];
        //maxInd记录每次最大值的下标，max记录最大值
        int maxInd = -1, max = Integer.MIN_VALUE;

        for (int i = 0; i < len - k + 1; i++) {
            //判断最大值下标是否在滑动窗口的范围内
            if (maxInd >= i && maxInd < i + k) {
                //存在就只需要比较最后面的值是否大于上一个窗口最大值
                if (nums[i + k - 1] > max) {
                    max = nums[i + k - 1];
                    //更新最大值下标
                    maxInd = i + k - 1;
                }
            }
            //如果不在就重新寻找当前窗口最大值
            else {
                max = nums[i];
                for (int j = i; j < i + k; j++) {
                    if (max < nums[j]) {
                        max = nums[j];
                        maxInd = j;
                    }
                }
            }
            res[i] = max;
        }
        return res;
    }

    //利用双端队列
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0)
            return new int[0];
        //队列头部永远是当前最大的值
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            //删除队列中所有小于当前值的数
            while ((!queue.isEmpty() && nums[queue.peekLast()] < nums[i])) {
                queue.removeLast();
            }
            queue.add(i);
            //保证队列中的坐标都在窗口内
            while (queue.peekFirst() < i - k + 1) {
                queue.removeFirst();
            }
            //取队列头部的值
            if (i < k) {
                res[0] = nums[queue.peekFirst()];
            } else {
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
