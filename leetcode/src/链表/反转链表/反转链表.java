package 链表.反转链表;

import 链表.ListNode;

public class 反转链表 {
    //迭代解法
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            head = temp;
            pre = head;
        }
        return pre;
    }

    //递归解法
    public ListNode reverseList2(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
