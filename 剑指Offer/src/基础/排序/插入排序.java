package 基础.排序;

public class 插入排序 {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                swap(array, j, j - 1);
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
