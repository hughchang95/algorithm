package 字符串;

import java.util.HashSet;
import java.util.Set;

public class 字符串的排列 {
    //DFS，标记已访问过的数据
    Set<String> result = new HashSet<>();

    public String[] permutation(String s) {
        if (s.length()==0)
            return new String[0];
        boolean[] visited=new boolean[s.length()];
        getLetter(s,"",visited);
        return result.toArray(new String[result.size()]);
    }

    public void getLetter(String s, String letter, boolean[] visited) {
        if (s.length() == letter.length()) {
            result.add(letter);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char temp=s.charAt(i);
            if (visited[i])
                continue;
            visited[i]=true;
            getLetter(s,letter+String.valueOf(temp),visited);
            visited[i]=false;
        }
    }
}
