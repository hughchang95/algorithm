package 链表;

import java.util.Stack;

public class 两条链表的第一个公共节点 {
    //注意找的是公共节点不是值相同的节点
    //脑残解法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (headA != null) {
            s1.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            s2.push(headB);
            headB = headB.next;
        }
        ListNode result = null;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            ListNode l1 = s1.pop();
            ListNode l2 = s2.pop();
            if (l1 == l2)
                result = l1;
            else
                break;
        }
        return result;
    }

    //我们假设链表1的独有长度为p，链表2独有的长度为q，公共长度为L。
    //那么我们只需要初始化两个指针，每个指针分别走p + q + L ，那么交汇的地方一定是交点。如果没有交汇，也就是L为0，那么我们最后会同时走到null，我们返回null即可，也是满足题意的。
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode node1=headA;
        ListNode node2=headB;
        while (node1!=node2){
            node1=node1==null?headB:node1.next;
            node2=node2==null?headA:node2.next;
        }
        return node1;
    }

}
