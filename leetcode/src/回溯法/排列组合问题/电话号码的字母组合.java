package 回溯法.排列组合问题;

import java.util.LinkedList;
import java.util.List;

public class 电话号码的字母组合 {

    List<String> res = new LinkedList<>();

    //回溯法
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.equals("")) {
            return res;
        }
        String[][] graph = {{"a", "b", "c"}, {"d", "e", "f"},
                {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"},
                {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};
        char[] chars = digits.toCharArray();
        int len = chars.length;
        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            ints[i] = chars[i] - '2';
        }
        find(0, "", ints, graph);
        return res;
    }

    public void find(int start, String s, int[] ints, String[][] graph) {
        if (s.length() > ints.length) {
            return;
        }
        if (s.length() == ints.length) {
            res.add(s);
        } else {
            for (int i = start; i < ints.length; i++) {
                for (int j = 0; j < graph[ints[i]].length; j++) {
                    String now = s + graph[ints[i]][j];
                    find(i + 1, now, ints, graph);
                }
            }
        }
    }


}
