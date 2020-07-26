package 树;

import java.util.Stack;

public class 二叉树展开为链表 {
    //以链表的思想遍历二叉树
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            root.left = null;
            root.right = left;
            TreeNode temp = left;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = right;
            flatten(left);
        } else {
            flatten(right);
        }
    }

    //后序遍历+翻转指针，先遍历右边
    TreeNode pre = null;

    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten2(root.right);
        flatten2(root.left);
        pre.right = root;
        pre.left = null;
        pre = root;
    }


}
