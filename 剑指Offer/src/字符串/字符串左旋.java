package 字符串;

public class 字符串左旋 {
    //不要使用+操作
    public String reverseLeftWords(String s, int n) {
        return s.substring(n)+s.substring(0,n);
    }
}
