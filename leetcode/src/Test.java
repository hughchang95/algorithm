public class Test {
    public static void main(String[] args) {
        System.out.println(doSth("ABDDDCCBBD"));
    }

    public static String doSth(String s) {
        StringBuilder sb = new StringBuilder();
        int[] mark = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                mark[i]++;
                mark[i+1]++;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (mark[i] == 0) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

}
