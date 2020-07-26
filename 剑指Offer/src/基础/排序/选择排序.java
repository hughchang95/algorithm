package 基础.排序;

public class 选择排序 {
    public static void sort(int[] array) {
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = i;
            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIdx]) {
                    // 记录目前能找到的最小值元素的下标
                    minIdx = j;
                }
            }
            swap(array, i, minIdx);
        }
    }


    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        int[] array = {9, 4, 6, 7, 3, 2, 8, 5, 1};
        sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
