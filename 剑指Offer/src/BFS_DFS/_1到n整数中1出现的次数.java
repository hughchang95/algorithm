package BFS_DFS;

public class _1到n整数中1出现的次数 {
    public int countDigitOne(int n) {
        return count(n);
    }

    public int count(int n) {
        if (n <= 0)
            return 0;
        String s = String.valueOf(n);
        //首位
        int head = s.charAt(0) - '0';
        //1000
        int pow = (int) Math.pow(10, s.length() - 1);
        //除首位外的后几位
        int last = n - head * pow;
        if (head == 1) {
            //0~1000内的count+1XXX的个数+XXX内的count
            return count(pow - 1) + last + 1 + count(last);
        } else {
            //0~n000内的count+1000~1999+XXX内的count
            return head * count(pow - 1) + pow + count(last);
        }
    }
}
