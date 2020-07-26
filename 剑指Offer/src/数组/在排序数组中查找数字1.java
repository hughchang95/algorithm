package 数组;

public class 在排序数组中查找数字1 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] != target) {
                left++;
                continue;
            }
            if (nums[right] != target) {
                right--;
                continue;
            }
            return right - left + 1;
        }
        return 0;
    }

    //二分查找
    public static int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                int result = 1;
                int _left = mid - 1;
                int _right = mid + 1;
                while (_left >= left) {
                    if (nums[_left--] == target)
                        result++;
                    else break;
                }
                while (_right <= right) {
                    if (nums[_right++] == target)
                        result++;
                    else break;
                }
                return result;
            }
        }
        return 0;


    }
}

