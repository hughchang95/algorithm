package 练过的笔试题;

import java.util.Scanner;

public class 随机数去重排序 {

    public static int[] getBucket(int n, int[] ary) {
        int[] res = new int[1001];
        for (int i = 0; i < n; i++) {
            int temp = ary[i];
            res[temp] = 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int num = sc.nextInt();
            int[] ary=new int[num];
            for (int i = 0; i < num; i++) {
                ary[i]=sc.nextInt();
            }
            int[] bucket = getBucket(num, ary);
            for (int i = 0; i < 1001; i++) {
                if (bucket[i]==1){
                    System.out.println(i);
                }
            }
        }
        sc.close();
    }
}
