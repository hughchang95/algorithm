package 回溯法;

import java.util.LinkedList;
import java.util.List;

public class 分割回文串 {
    List<List<String>> res = new LinkedList<>();

    public List<List<String>> partition(String s) {
        find(0,new LinkedList<>(),s);
        return res;
    }

    public void find(int start,LinkedList<String> track,String s) {
        if (start==s.length()){
            res.add(track);
        }
        for (int i = start; i < s.length(); i++) {
            if (is(s.substring(0,start))){
                track.add(s.substring(0,start));
                find(i+1,track,s);
                track.remove(track.size()-1);
            }

        }
    }

    public boolean is(String s) {
        int len = s.length();
        if (len == 1) {
            return true;
        }
        int i = 0;
        int j = len - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
