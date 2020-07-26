package 数组;

import java.util.HashMap;
import java.util.Map;

public class 数组中数字出现的次数2 {
    //HashMap
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            count = count == null ? 0 : count;
            map.put(num, ++count);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return 0;
    }

    //位比较
    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            int bit = 1 << i;
            for (int num : nums) {
                if ((num & bit) != 0)
                    count++;
            }
            if (count % 3 != 0)
                res += bit;
        }
        return res;
    }

}
