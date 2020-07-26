package 链表.反转链表;

import 链表.ListNode;

public class 反转链表3 {


    ListNode reverseBetween(ListNode head, int m, int n) {
        //当m=1时认为m为头节点
        if (m == 1) {
            //利用reverse（1，n）进行反转，此时的n为n-m+1
            return reverseN(head, n);
        }
        //递归到m=1时
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    ListNode mark = null;
    ListNode reverseN(ListNode head, int m) {
        if (m == 1) {
            mark = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, m - 1);
        head.next.next = head;
        head.next = mark;
        return last;
    }

    //头插法
    ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;

        ListNode mark = pre;
        ListNode move = pre.next;

        int count = 0;
        while (m - 1 > count) {
            mark = mark.next;
            move = move.next;
            count++;
        }
        for (int i = 0; i < n - m; i++) {
            ListNode temp = move.next;
            move.next = move.next.next;
            temp.next = mark.next;
            mark.next = temp;
        }
        return pre.next;

    }
}
