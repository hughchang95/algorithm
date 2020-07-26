package 树;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 二叉树的中序遍历 {

    //递归
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        LinkedList<Integer> list = new LinkedList<>();
        inorderTraversal(root, list);
        return list;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorderTraversal(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right, list);
        }
    }

    //迭代
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        //当前节点不为空，stack只存储（当前的）左节点，没有左节点直接返回了
        while (root != null || !stack.isEmpty()) {
            //先处理左边节点，此时root用于追踪左侧节点
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            //对当前处理节点取右节点，两种情况进入：需要左节点已经取完
            if (!stack.isEmpty()) {
                //处理栈顶结点，此时root指向当前节点
                root = stack.pop();
                list.add(root.val);
                //处理右侧节点
                root = root.right;
            }
        }
        return list;
    }
}
