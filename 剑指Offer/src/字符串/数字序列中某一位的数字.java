package 字符串;

public class 数字序列中某一位的数字 {
    public static int findNthDigit(int n) {
        if (n <= 9) return n;// 前9位搞定
        int count = n + 1;//需要找到的位数。
        double num = 2;//在两位数区间里找
        double left = count - 10;//还需要找的位数
        double tmp;
        while (left > (tmp = num * (9 * (int) Math.pow(10, num - 1)))) {//如果
            left -= tmp;
            num++;
        }
        int begin = (int) (Math.pow(10, num - 1));
        int index = (int)left / (int)num;
        int ano = (int)left % (int)num;
        if (ano == 0) return (begin + index - 1) % 10;
        return ((begin + index) / (int) (Math.pow(10, num - ano))) % 10;
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(1000));
    }
}
