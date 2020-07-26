package 基础.排序;

public class 堆排序 {
    //排序
    public static void sort(int[] array) {
        makeHeap(array);

    }

    //构建大顶堆
    public static void makeHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }
        //从末尾元素开始上滤，每次将最大元素固定在尾部
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, 0, i);
            adjustHeap(array, 0, i);
        }
    }

    //大顶堆堆序
    public static void adjustHeap(int[] array, int target, int length) {
        int temp = array[target];
        //遍历子节点
        for (int i = target * 2 + 1; i < length; i = i * 2 + 1) {
            //选择左节点或右节点
            if (i + 1 < length && array[i] < array[i + 1])
                i++;
            //子节点大于父节点
            if (array[i] > temp) {
                //子节点复制给父节点，不是交换
                array[target] = array[i];
                //指针指向子节点
                target = i;
            } else
                break;
        }
        array[target] = temp;
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
