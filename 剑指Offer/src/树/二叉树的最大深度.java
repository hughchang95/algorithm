package 树;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最大深度 {
    //递归
    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    //BFS 层序遍历 利用队列
    public int maxDepth2(TreeNode root){
        if (root==null)
            return 0;
        int maxDepth=0;
        Queue<TreeNode> queue=new LinkedList<>();
        //初始队列
        queue.add(root);
        //队列为空说明遍历结束
        while (!queue.isEmpty()){
            //本层节点数
            int n=queue.size();
            //对本层节点进行操作
            for (int i = 0; i < n; i++) {
                //取出一个节点
                TreeNode curNode = queue.poll();
                //对该节点进行操作
                //下层节点入队
                if (curNode.left!=null)
                    queue.add(curNode.left);
                if (curNode.right!=null)
                    queue.add(curNode.right);
            }
            //每结束一层进行的操作
            maxDepth++;
        }
        return maxDepth;
    }
}
