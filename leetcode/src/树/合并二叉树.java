package 树;

/**
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 */
public class 合并二叉树 {
    //递归遍历，将结果叠加在t1上
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //都不存在，返回空节点
        if (t1 == null && t2 == null) {
            return null;
        }
        //1不存在，2存在，接下来在t2上遍历
        if (t1 == null) {
            return t2;
        }
        //2不存在，1存在，接下来在t1上遍历
        if (t2 == null) {
            return t1;
        }
        //重叠：相加对应位置值
        t1.val += t2.val;
        //递归，以t1为结果
        t1.left=mergeTrees(t1.left, t2.left);
        t1.right=mergeTrees(t1.right, t2.right);
        return t1;
    }
}
