package 练过的笔试题;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class 合并表记录 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        TreeMap<Integer, Integer> map = new TreeMap<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                }
        );
        for (int i = 0; i < n; i++) {
            int key = nums[i][0];
            int value = nums[i][1];
            if (map.containsKey(key)) {
                int newValue = map.get(key) + value;
                map.put(key, newValue);
            } else {
                map.put(key, value);
            }
        }

        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> entry = map.firstEntry();
            System.out.println(entry.getKey() + " " + entry.getValue());
            map.remove(entry.getKey());
        }

    }


}
