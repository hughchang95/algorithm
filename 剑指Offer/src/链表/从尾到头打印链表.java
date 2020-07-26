package 链表;

import java.util.ArrayList;
import java.util.Stack;

public class 从尾到头打印链表 {
    //入栈出栈
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> array=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        ListNode temp=listNode;
        while (temp!=null){
            stack.push(temp.val);
            temp=temp.next;
        }
        while (!stack.isEmpty()){
            array.add(stack.pop());
        }
        return array;
    }

    //利用array按坐标add方法避免第二次迭代
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> array=new ArrayList<>();
        ListNode temp=listNode;
        while (temp!=null){
            array.add(0,temp.val);
            temp=temp.next;
        }
        return array;
    }

    //递归
    ArrayList<Integer> arrayList=new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        if (listNode!=null){
            printListFromTailToHead3(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

}

