package 栈;

import java.util.Stack;

public class 包含min函数的栈 {
    //使用一个辅助栈，长度与原栈相同，每个位置代表原栈cut到这个长度时的最小值。
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    /** initialize your data structure here. */
    public 包含min函数的栈() {
        s1=new Stack<>();
        s2=new Stack<>();
    }

    public void push(int x) {
        s1.add(x);
        if(s2.empty()||s2.peek()>x)
            s2.add(x);
        else
            s2.add(s2.peek());
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }

}
