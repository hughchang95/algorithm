package 链表;

import java.util.Stack;

public class 两数相加2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> a = new Stack<>();
        Stack<ListNode> b = new Stack<>();
        while (l1 != null) {
            a.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            b.push(l2);
            l2 = l2.next;
        }
        ListNode head = new ListNode(-1);
        int carry = 0;
        while (!a.isEmpty() || !b.isEmpty() || carry > 0) {
            int sum = carry;
            sum += a.isEmpty() ? 0 : a.pop().val;
            sum += b.isEmpty() ? 0 : b.pop().val;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            node.next = head.next;
            head.next = node;
        }
        return head.next;
    }
}
