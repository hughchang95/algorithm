package 数学;

public class 打印从1到最大的n位数 {
    public int[] printNumbers(int n) {
        //找到边界
        int max = (int) Math.pow(10, n);
        int[] result = new int[max - 1];
        //遍历
        for (int i = 1; i < max; i++) {
            result[i] = i;
        }
        return result;
    }
}
