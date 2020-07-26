package 树;

public class 二叉搜索树与双向链表 {
    Node head, pre, tail;

    public Node treeToDoublyList(Node root) {
        if (root==null)
            return root;
        inorder(root);
        head.left=tail;
        tail.right=head;
        return head;
    }

    public void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        if (pre == null) {
            head = root;
        } else
            pre.right = root;
        root.left = pre;
        pre = root;
        tail = root;
        inorder(root.right);
    }
}
