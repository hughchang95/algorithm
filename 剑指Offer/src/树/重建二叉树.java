package 树;

import java.util.HashMap;
import java.util.Map;

public class 重建二叉树 {
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        TreeNode root=buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return root;
    }

    public TreeNode buildTree(int[] preorder,int preStart,int preEnd, int[] inorder,int inStart,int inEnd){
        if (preStart>preEnd)
            return null;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        if (preStart==preEnd)
            return root;
        int idx=map.get(rootVal);
        int leftSize=idx-inStart;
        int rightSize=inEnd-idx;
        root.left=buildTree(preorder,preStart+1,preEnd-rightSize,inorder,inStart,inEnd-rightSize-1);
        root.right=buildTree(preorder,preStart+leftSize+1,preEnd,inorder,inStart+leftSize+1,inEnd);
        return root;
    }
}
