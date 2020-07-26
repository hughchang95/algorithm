package 数组.双指针;

import java.util.ArrayList;
import java.util.List;

public class 求众数2 {
    //注意点：超过1/n的票数的候选者最多有n-1个
    public List<Integer> majorityElement(int[] nums) {
        //需要n-1个标记，对应n-1个计数器
        int a = 0;
        int counta = 0;
        int b = 0;
        int countb = 0;
        for (int num : nums) {
            //票数抵消时更新候选者，第一次初始化标记
            if (counta == 0) {
                a = num;
                //注意给新的候选人加一
                counta++;
            } else if (countb == 0) {
                b = num;
                countb++;
            }
            //相同时加一票
            else if (a == num) {
                counta++;
            } else if (b == num) {
                countb++;
            }
            //不属于当前候选者时都减一票
            else {
                counta--;
                countb--;
            }
        }
        //必要的统计票数阶段，避免没有优胜者
        //此时知识选出两个最高票
        counta = countb = 0;
        for (int num : nums) {
            if (a == num) {
                counta++;
            }
            //注意不要粗心用else
            else if (b == num) {
                countb++;
            }
        }
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        //还是要最终判断
        if (counta > length / 3) {
            list.add(a);
        }
        if (countb > length / 3) {
            list.add(b);
        }
        return list;
    }
}
