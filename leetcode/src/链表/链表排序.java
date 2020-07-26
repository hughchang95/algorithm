package 链表;

public class 链表排序 {
    //链表的归并排序：快慢指针+归并排序
    public ListNode sortList(ListNode head) {
        //返回条件
        if (head == null || head.next == null) {
            return head;
        }
        //找到重点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode headB = slow.next;
        slow.next = null;
        //根据中点分割
        ListNode left = sortList(head);
        ListNode right = sortList(headB);
        //合并
        return merge(left, right);

    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode mark = new ListNode(-1);
        ListNode res = mark;
        while (left != null && right != null) {
            if (left.val > right.val) {
                mark.next = right;
                right = right.next;
            } else {
                mark.next = left;
                left = left.next;
            }
            mark = mark.next;
        }
        while (left != null) {
            mark.next = left;
            left = left.next;
            mark = mark.next;
        }
        while (right != null) {
            mark.next = right;
            right = right.next;
            mark = mark.next;
        }
        return res.next;
    }
}
