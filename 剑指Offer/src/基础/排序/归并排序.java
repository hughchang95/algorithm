package 基础.排序;

import java.util.Arrays;

public class 归并排序 {
    public static void sort(int[] array) {

        mergrsort(array, 0, array.length - 1);
    }

    public static void mergrsort(int[] array, int left, int right) {
        if (left >= right)
            return;
        int mid = (left + right) >> 1;
        mergrsort(array, left, mid);
        mergrsort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[array.length];
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (array[i] < array[j])
                temp[k++] = array[i++];
            else
                temp[k++] = array[j++];
        }
        while (i <= mid)
            temp[k++] = array[i++];
        while (j <= right)
            temp[k++] = array[j++];

        for (int l = left; l <= right; l++) {
            array[l] = temp[l];
        }
    }


    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 3, 6, 1, 8, 6, 5, 4, 2, 3, 9, 5, 4};
        sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

}