package 字符串;

import java.util.*;

public class 字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        boolean[] visited = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (!visited[i]) {
                List<String> list = new LinkedList<>();
                list.add(strs[i]);
                visited[i] = true;
                for (int j = i + 1; j < strs.length; j++) {
                    if (stringSame(strs[i], strs[j])) {
                        list.add(strs[j]);
                        visited[j] = true;
                    }
                }
                res.add(list);
            }
        }
        return res;
    }

    //通过桶计数解决
    public boolean stringSame(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] bucket = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            bucket[s1.charAt(i)]++;
            bucket[s2.charAt(i)]--;
        }
        for (int aBucket : bucket) {
            if (aBucket != 0) {
                return false;
            }
        }
        return true;
    }

    //异位词可以用排序解决
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                map.put(s, new LinkedList<>());
            }
        }
        return new LinkedList<>(map.values());
    }

}
