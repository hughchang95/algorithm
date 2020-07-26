package 链表.反转链表;

import 链表.ListNode;

public class 反转链表2 {
    //用于保存分裂处的下一个节点
    ListNode marker = null;

    ListNode reverseN(ListNode head, int n) {
        //当达到分裂节点时，记录下一个节点
        if (n == 1) {
            marker = head.next;
            return head;
        }
        //此时已经得到了反转好的头节点
        ListNode last = reverseN(head.next, n - 1);
        //在当前节点处反转
        head.next.next = head;
        //连接到分裂处
        head.next = marker;
        return last;
    }

    //头插法
    ListNode reverseN2(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        int count = 0;
        while (count < n - 1) {
            ListNode temp = head.next;
            head.next = head.next.next;
            temp.next = pre.next;
            pre.next = temp;
            count++;
        }
        return pre.next;
    }
}
