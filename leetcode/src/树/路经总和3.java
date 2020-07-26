package 树;

import java.util.HashMap;
import java.util.Map;

public class 路经总和3 {

    //核心：如果 当前前缀和-目标=某一前缀和 ，那么存在路径
    public int pathSum(TreeNode root, int sum) {
        //用HashMap存储“当前前缀和-当前前缀和出现次数”
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        //初始前缀和为0；
        prefixMap.put(0, 1);
        return getSum(root, sum, prefixMap, 0);
    }

    //dfs搜索
    public int getSum(TreeNode root, int sum, Map<Integer, Integer> prefixMap, int curSum) {
        if (root == null) {
            return 0;
        }
        //本层的工作
        int res = 0;
        curSum += root.val;
        //判断是否存在，存在则增加已出现的次数，否则加0；
        res += prefixMap.getOrDefault(curSum - sum, 0);
        //将本层的前缀和加入
        prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) + 1);

        //递归进入子树
        res += getSum(root.left, sum, prefixMap, curSum);
        res += getSum(root.right, sum, prefixMap, curSum);

        //回溯本层的改动
        prefixMap.put(curSum, prefixMap.get(curSum) - 1);

        return res;
    }
}
