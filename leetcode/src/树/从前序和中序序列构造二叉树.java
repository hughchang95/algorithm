package 树;

public class 从前序和中序序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)
            return null;
        return buildTree(preorder, inorder, 0, 0, preorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int pr, int ilb, int ire) {
        if(pr>=preorder.length||ilb>ire){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pr]);
        int ir = 0;
        for (int i = ilb; i <= ire; i++) {
            if (inorder[i] == preorder[pr]) {
                ir = i;
            }
        }
        root.left = buildTree(preorder, inorder, pr + 1, ilb, ir - 1);
        root.right = buildTree(preorder, inorder, pr + 1 + ir - ilb, ir + 1, ire);
        return root;
    }
}
