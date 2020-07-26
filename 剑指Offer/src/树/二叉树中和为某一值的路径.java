package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树中和为某一值的路径 {
    private List<List<Integer>> result = new LinkedList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        path(root, sum);
        return result;
    }

    private void path(TreeNode root, int sum) {
        //边界条件处理
        if (root == null)
            return;
        //遍历所有情况开始
        path.add(root.val);
        //检查条件
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            //标记
            result.add(new LinkedList<>(path));//此处要新建一个复制的path
        }
        path(root.left, sum);
        path(root.right, sum);
        //向上回溯（一步）
        path.removeLast();
        //遍历所有情况结束
    }
}


