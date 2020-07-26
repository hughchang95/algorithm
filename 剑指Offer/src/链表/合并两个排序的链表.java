package 链表;

import org.junit.Test;

public class 合并两个排序的链表 {
    //归并排序的思路，递归解法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //输入检测
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        //定义结果头
        ListNode result;
        if (l1.val <= l2.val) {
            result = l1;
            //在已接受值上推进
            result.next = mergeTwoLists(l1.next, l2);
        } else {
            result = l2;
            result.next = mergeTwoLists(l1, l2.next);
        }
        return result;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        //输入检测
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        //定义结果头,保存头位置
        ListNode head = new ListNode(-1);
        //结果链表标记
        ListNode temp = head;
        //任意一方到底时跳出
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                //将该节点加入结果
                temp.next = l1;
                //移动参数列表标记
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            //移动结果链表标记
            temp = temp.next;
        }
        //将没到底的链表遍历完
        while (l1 != null) {
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }
        while (l2 != null) {
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }
        //返回头的下一个
        return head.next;
    }


    @Test
    public void Test() {
        System.out.println(mergeTwoLists(null, null) == null);
    }
}
