package 树;

public class 树的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
        return false;
        if (A.val == B.val) {
            if (B.left == null && B.right == null) {
                return true;
            }
            return isSubStructure(A.right,B.right)||isSubStructure(A.left,B.left);
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
}
