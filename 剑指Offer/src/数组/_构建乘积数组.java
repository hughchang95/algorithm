package 数组;

public class _构建乘积数组 {
    public int[] constructArr(int[] a) {
        int len=a.length;
        if (len==0)
            return a;
        //左边数组保存正向叠乘
        int[] left = new int[len];
        //右边数组保存反向叠乘
        int[] right = new int[len];
        left[0]=1;
        right[len-1]=1;
        for (int i = 1; i < len; i++) {
            left[i]=left[i-1]*a[i-1];
            right[len-i-1]=right[len-i]*a[len-i];
        }
        for (int i = 0; i < len; i++) {
            left[i]*=right[i];
        }
        return left;
    }

    public int[] constructArr2(int[] a) {
        int len=a.length;
        if (len==0)
            return a;
        //左边数组保存正向叠乘,取消右边数组
        int[] left = new int[len];
        left[0]=1;
        for (int i = 1; i < len; i++) {
            left[i]=left[i-1]*a[i-1];
        }
        int temp=1;
        for (int i = len-2; i >=0; i--) {
            temp*=a[i+1];
            left[i]*=temp;
        }
        return left;
    }
}
