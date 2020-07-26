package 栈;

import java.util.LinkedList;
import java.util.Queue;

public class 队列的最大值 {
    public static void main(String[] args) {
        MaxQueue maxQueue=new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());

    }
}

class MaxQueue {
    private Queue<Integer> queue;
    private LinkedList<Integer> list;

    public MaxQueue() {
        queue = new LinkedList<>();
        list = new LinkedList<>();
    }

    public int max_value() {
        if (queue.isEmpty()||list.isEmpty())
            return -1;
        return list.peekFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (!list.isEmpty() && list.peekLast() < value)
            list.removeLast();
        list.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty())
            return -1;
        Integer poll = queue.poll();
        if (!list.isEmpty() &&list.peekFirst().equals(poll))
            list.removeFirst();
        return poll;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
