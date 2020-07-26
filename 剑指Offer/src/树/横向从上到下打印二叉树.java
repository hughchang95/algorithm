package 树;

import java.util.ArrayList;
import java.util.List;

public class 横向从上到下打印二叉树 {
    //层次优先遍历
    public int[] levelOrder(TreeNode root) {
        if (root==null)
            return new int[0];
        List<TreeNode> list=new ArrayList<>();
        int i=0;
        list.add(root);
        while (i<list.size()){
            TreeNode mid=list.get(i);
            if (mid.left!=null)
                list.add(mid.left);
            if (mid.right!=null)
                list.add(mid.right);
            i++;
        }
        int [] res=new int[list.size()];
        for (int j=0;j<list.size();j++)
            res[j]=list.get(j).val;
        return res;
    }
}
