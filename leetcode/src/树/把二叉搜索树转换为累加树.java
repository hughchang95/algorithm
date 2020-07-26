package 树;

public class 把二叉搜索树转换为累加树 {
    //累加时应该维护一个全局变量，否则递归时使用的永远是当时那层传入的变量
    private static int sum = 0;

    public static TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    public static void convert(TreeNode root) {
        if (root == null) {
            return;
        }
        convert(root.right);
        sum += root.val;
        root.val = sum;
        convert(root.left);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(13);
        a.left = b;
        a.right = c;
        convertBST(a);
    }
}
