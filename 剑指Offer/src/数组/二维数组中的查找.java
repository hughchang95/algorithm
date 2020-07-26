package 数组;

public class 二维数组中的查找 {
    //暴力破解不写了
    //对角线比较
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int i = row - 1;
        int j = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] < target)
                j++;
            else if (matrix[i][j] > target)
                i--;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {};
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
        二维数组中的查找 aa = new 二维数组中的查找();
        boolean numberIn2DArray = aa.findNumberIn2DArray(a, 3);
        System.out.println(numberIn2DArray);
    }
}
