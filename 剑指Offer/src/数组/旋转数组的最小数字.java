package 数组;

import java.util.Arrays;

public class 旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }

//    题目中给出的是半有序数组，虽然传统二分告诉我们二分只能用在有序数组中，但事实上，只要是可以减治的问题，仍然可以使用二分思想。
//    思路：数组中最特殊的位置是左边位置 left 和右边位置 right，将它们与中间位置 mid 的值进行比较，进而判断最小数字出现在哪里。
//
//    用左边位置 left 和中间位置 mid 的值进行比较是否可以？
//
//    举例：[3, 4, 5, 1, 2] 与 [1, 2, 3, 4, 5] ，此时，中间位置的值都比左边大，但最小值一个在后面，一个在前面，因此这种做法不能有效地减治。
//
//    用右边位置 right 和中间位置 mid 的值进行比较是否可以？
//
//    举例：[1, 2, 3, 4, 5]、[3, 4, 5, 1, 2]、[2, 3, 4, 5 ,1]，用右边位置和中间位置的元素比较，可以进一步缩小搜索的范围。
//    补充说明：遇到 nums[mid] == nums[right] 的时候，不能草率地下定结论最小数字在哪一边，但是可以确定的是，把 right 舍弃掉，并不影响结果。

    public static int minArray2(int[] numbers) {
        int head=0;
        int tail=numbers.length-1;
        while (head<tail){
            int mark=(tail+head)>>1;
            if (numbers[mark]>numbers[tail])
                head=mark+1;
            else if (numbers[mark]==numbers[tail])
                tail=tail-1;
            else
                tail=mark;
        }
        return numbers[head];
    }

    public static void main(String[] args) {
        int[] a={3,1,1};
        System.out.println(minArray2(a));
    }
}
