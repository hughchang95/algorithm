package 栈;

import java.util.Stack;
//汉诺塔问题
public class 用两个栈实现队列 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public 用两个栈实现队列() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public int deleteHead() {
        if (stack1.isEmpty())
            return -1;
        return stack1.pop();
    }
}
