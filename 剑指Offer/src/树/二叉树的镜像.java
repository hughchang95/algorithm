package 树;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的镜像 {
    //遍历交换，递归
    public TreeNode mirrorTree(TreeNode root){
        if (root==null||(root.left==null&&root.right==null))
            return root;
        mirror(root);
        return root;
    }

    public void mirror(TreeNode root){
        if (root==null)
            return;
        //交换
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        //递归
        mirror(root.left);
        mirror(root.right);
    }

    //广度优先遍历
    public TreeNode mirrorTree2(TreeNode root) {
        if (root==null)
            return root;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n=queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode curNode = queue.poll();
                TreeNode tempNode=curNode.left;
                curNode.left=curNode.right;
                curNode.right=tempNode;
                if (curNode.left!=null)
                    queue.add(curNode.left);
                if (curNode.right!=null)
                    queue.add(curNode.right);
            }
        }
        return root;
    }

}
