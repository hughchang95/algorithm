package 数组;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 最小的k个数 {
    //堆解法待实现

    //直接排序
    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }

    //优先权队列
    public static int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        //优先队列的作用是能保证每次取出的元素都是队列中权值最小的
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        for (int i : arr) {
            if (queue.size() < k) {
                queue.add(i);
            } else {
                if (queue.peek() > i) {
                    queue.remove();
                    queue.add(i);
                }
            }
        }
        int[] ref = new int[k];
        int cnt = 0;
        while (queue.size() > 0) {
            ref[cnt++] = queue.remove();
        }
        return ref;

    }

    public static int[] getLeastNumbers3(int[] arr, int k) {
        makeHeap(arr, arr.length);
        for (int i = arr.length-1; i >=0 ; i--) {
            swap(arr,0,i);
            adjustHeap(arr,0,i);
        }
        int[] karr=new int[k];
        System.arraycopy(arr,0,karr,0,k);
        return karr;
    }

    public static void makeHeap(int[] arr, int length) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, length);

        }
    }

    public static void adjustHeap(int[] arr, int target, int length) {
        int temp = arr[target];
        for (int i = target * 2 + 1; i < length; i = i * 2 + 1) {
            if (i + 1 < length && arr[i] < arr[i + 1])
                i++;
            if (arr[i] > temp) {
                arr[target] = arr[i];
                target = i;
            } else break;
        }
        arr[target] = temp;
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


    public static void main(String[] args) {
        int[] a = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        int[] leastNumbers = getLeastNumbers3(a, 8);
        for (int leastNumber : leastNumbers) {
            System.out.println(leastNumber);
        }
    }
}
