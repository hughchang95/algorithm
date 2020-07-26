package 数学;

public class 不用关键字求和 {
    public int sumNums(int n) {
        int sum = n;
        boolean b = n > 0 && (sum += sumNums(n - 1)) > 0;
        return sum;
    }
}
