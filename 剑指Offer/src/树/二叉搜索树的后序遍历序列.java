package 树;

public class 二叉搜索树的后序遍历序列 {
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder,0,postorder.length-1);
    }

    /**
     * 思路：与根节点比较以分割左右子树，检查左子树是否合格，递归检查
     * @param postorder 原数组
     * @param left 左边起点
     * @param right 根节点
     * @return
     */
    public boolean verify(int[] postorder, int left, int right) {
        if (left >= right)
            return true;
        int root = right;
        while (postorder[right] >= postorder[root] && left < right) {
            right--;
        }
        for (int i = left; i < right; i++) {
            if (postorder[i] > postorder[root])
                return false;
        }
        return verify(postorder, right + 1, root - 1) && verify(postorder, left, right);

    }
}
