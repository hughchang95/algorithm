package 树;

import java.util.*;

public class 之字形打印二叉树 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if(root==null)return resList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int num=0;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curNode =queue.poll();
                list.add(curNode.val);
                if(curNode.left != null)queue.add(curNode.left);
                if(curNode.right != null)queue.add(curNode.right);
            }
            num++;
            if(num%2==0) Collections.reverse(list);
            resList.add(list);
        }
        return resList;
    }
}
