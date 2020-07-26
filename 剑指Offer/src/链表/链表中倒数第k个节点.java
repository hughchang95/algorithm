package 链表;

import java.util.Stack;

public class 链表中倒数第k个节点 {
    //栈
    public ListNode getKthFromEnd(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        for (int i = 1; i < k; i++) {
            stack.pop();
        }
        return stack.peek();
    }

    //快慢指针
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            temp = temp.next;
        }
        while (temp != null) {
            temp = temp.next;
            head = head.next;
        }
        return head;
    }

    //快慢指针优美版
    public ListNode getKthFromEnd3(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
            if (count > k)
                head = head.next;
        }
        return head;
    }
}
