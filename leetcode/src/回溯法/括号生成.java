package 回溯法;

import java.util.LinkedList;
import java.util.List;

public class 括号生成 {
    List<String> res = new LinkedList<>();

    //分情况回溯的回溯法
    public List<String> generateParenthesis(int n) {
        StringBuffer sb = new StringBuffer();
        process(0, 0, n, sb);
        return res;
    }

    public void process(int l, int r, int n, StringBuffer sb) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }
        if (l < n) {
            sb.append("(");
            process(l + 1, r, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r < l) {
            sb.append(")");
            process(l, r + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
