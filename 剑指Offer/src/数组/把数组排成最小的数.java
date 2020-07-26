package 数组;

import java.util.Arrays;
import java.util.Comparator;

public class 把数组排成最小的数 {
    public String minNumber(int[] nums) {
        String[] numsStr=new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(numsStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        StringBuilder sb=new StringBuilder();
        for (String s : numsStr) {
            sb.append(s);
        }
        return sb.toString();
    }
}
