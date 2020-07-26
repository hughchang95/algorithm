package 数学;

public class 不用加减乘除做加法 {
    //加法
    public static int add(int a, int b) {
        return b == 0 ? a : add(a ^ b, (a & b) << 1);
    }

    //减法
    public static int nagtive(int a){
        return add(~a,1);
    }
    public static int sub(int a,int b){
        return add(a,nagtive(b));
    }

    public static void main(String[] args) {
        System.out.println(add(1, 1));
    }
}
