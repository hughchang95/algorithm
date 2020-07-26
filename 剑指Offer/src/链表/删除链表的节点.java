package 链表;

public class 删除链表的节点 {
    //指针迭代
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null)
            return null;
        //分段验证，掐头
        if (head.val == val)
            return head.next;
        ListNode result = head;
        ListNode after = head.next;
        //在after节点上进行操作
        while (after.next != null) {
            if (after.val == val) {
                head.next = after.next;
                return result;
            }
            head = after;
            after = after.next;
        }
        //去尾
        if (after.val == val)
            head.next = null;
        return result;
    }

    //递归
    public ListNode deleteNode2(ListNode head, int val) {
        if (head.val == val)
            return head.next;
        //最后一位肯定在链表中，所以提前返回
        head.next=deleteNode2(head.next,val);
        return head;
    }
}
