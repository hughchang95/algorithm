package 基础.排序;

public class 快速排序 {
    public static void sort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    public static void quicksort(int[] array, int left, int right) {
        if (left >= right)
            return;
        int key = array[left];
        int i = left;
        int j = right;
        while (true) {
            while (array[j] >= key && i < j)
                j--;
            while (array[i] <= key && i < j)
                i++;
            if (i < j)
                swap(array, i, j);
            else
                break;
        }
        swap(array,left,i);
        quicksort(array,left,i-1);
        quicksort(array,i+1,right);
    }


    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3};
        sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
