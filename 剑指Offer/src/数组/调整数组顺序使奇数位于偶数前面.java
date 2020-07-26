package 数组;

public class 调整数组顺序使奇数位于偶数前面 {
    //扫描交换
    public static int[] exchange(int[] nums) {
        int i = 0;
        int j = 0;
        while (i < nums.length - 1) {
            if (nums[i] % 2 == 0) {
                for (j = i + 1; j < nums.length - 1; j++) {
                    if (nums[j] % 2 != 0)
                        break;
                }
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            } else
                i++;
        }
        return nums;
    }

    //双向指针
    public static int[] exchange2(int[] nums) {
        //左边指针找偶数
        int i = 0;
        //右边指针找奇数
        int j = nums.length - 1;
        while (i < j) {
            //找到奇数动一下
            if (nums[i] % 2 != 0) {
                i++;
                //一次循环只动一个
                continue;
            }
            //找到偶数动一下
            if (nums[j] % 2 == 0) {
                j--;
                continue;
            }
            //交换
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }
        return nums;
    }

    //快慢指针
//    定义快慢双指针 fast 和 low ，fast 在前， low在后 .
//    fast 的作用是向前搜索奇数位置，low 的作用是指向下一个奇数应当存放的位置
//    fast向前移动，当它搜索到奇数时，将它和 nums[low]交换，此时 low向前移动一个位置 .
//    重复上述操作，直到 fast指向数组末尾 .

    public static int[] exchange3(int[] nums) {
        int fast = 0;
        int low = 0;
        while (fast < nums.length) {
            if (nums[fast] % 2 != 0) {
                int temp = nums[fast];
                nums[fast] = nums[low];
                nums[low] = temp;
                //low指向的地方只能放奇数
                low++;
            }
            fast++;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] exchange = exchange3(a);
        for (int i : exchange) {
            System.out.println(i);
        }
    }
}
