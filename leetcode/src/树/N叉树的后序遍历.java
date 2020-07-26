package 树;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class N叉树的后序遍历 {
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new LinkedList<>();
        }
        LinkedList<Integer> res = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.addFirst(node.val);
            List<Node> children = node.children;
            for (Node child : children) {
                stack.push(child);
            }
        }
        return res;
    }
}
