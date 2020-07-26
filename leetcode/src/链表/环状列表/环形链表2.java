package 链表.环状列表;

import 链表.ListNode;

public class 环形链表2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode mark = null;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                mark = slow;
                break;
            }
        }
        if (mark == null) {
            return mark;
        }
        while (head != mark) {
            head = head.next;
            mark = mark.next;
        }
        return head;
    }
}
