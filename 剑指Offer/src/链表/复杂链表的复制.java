package 链表;

import java.util.HashMap;

public class 复杂链表的复制 {
    //使用map存储原节点和现节点，遍历map将原节点信息移植
    //对应关系的理解很重要！！
    public Node copyRandomList1(Node head) {
        if (head == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node mark1 = head;
        Node mark2 = head;
        while (mark1 != null) {
            //建立对应关系
            map.put(mark1, new Node(mark1.val));
            mark1 = mark1.next;
        }
        while (mark2 != null) {
            //避免空指针异常
            if (mark2.next == null)
                map.get(mark2).next = null;
            else
                //重要！右边是现节点next指向，左边是原节点的next对应的现节点
                map.get(mark2).next = map.get(mark2.next);
            map.get(mark2).random = map.get(mark2.random);
            mark2 = mark2.next;
        }
        return map.get(head);
    }

    //复制-控制-拆分
    public Node copyRandomList2(Node head) {
        if (head == null)
            return head;

        //设置重置标记
        Node markHead = head;
        //在每个节点后插入值相同的节点
        while (markHead != null) {
            Node temp = new Node(markHead.val);
            Node nextNode = markHead.next;
            markHead.next = temp;
            temp.next = nextNode;
            markHead = nextNode;
        }

        //通过链表操作，复制random指向
        markHead = head;
        while (markHead != null) {
            Node temp = markHead.next;
            if (markHead.random != null)
                //复制后的指向永远在原指向后一个
                temp.random = markHead.random.next;
            markHead = temp.next;
        }

        //拆分链表
        Node resultHead = head.next;
        markHead = head;
        while (markHead != null) {
            Node result=markHead.next;
            markHead.next=result.next;
            if (result.next!=null)
                result.next=result.next.next;
            markHead=markHead.next;
        }
        return resultHead;
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}