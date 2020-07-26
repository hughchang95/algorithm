package 树;

public class 二叉搜索树的后序遍历 {
    //后序遍历，最后一个为根节点，遍历数组找到第一个大于根节点的，然后判断后面的全部都是大于根节点的，然后分为两部分，左右子树，左子树为left到temp-1，右子树为temp到right-1，递归。
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length <= 2) return true;
        return verifySeq(postorder, 0, postorder.length - 1);
    }

    private boolean verifySeq(int[] postorder, int start, int end) {
        if (start >= end) return true;
        int i;
        //找到第一个大于sequence[end]的数
        for (i = start; i < end; i++) {
            if (postorder[i] > postorder[end]) break;
        }
        // 验证后面的是否都大于sequence[end]
        for (int j = i; j < end; j++) {
            if (postorder[j] < postorder[end]) return false;
        }
        return verifySeq(postorder, start, i - 1) && verifySeq(postorder, i, end - 1);
    }
}
