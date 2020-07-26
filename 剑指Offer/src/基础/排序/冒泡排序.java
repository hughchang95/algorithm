package 基础.排序;

public class 冒泡排序 {

    public static void sort(int[] array) {
        //已固定的位数
        for (int i = 0; i < array.length; i++) {
            //每次遍历都减去已固定位数
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1])
                    swap(array, j, j + 1);
            }
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
