package 队列和栈;

import java.util.*;

public class LRU缓存机制 {

    public static void main(String[] args) {
        LRUCache2 testAll = new LRUCache2(3);
        testAll.put(1, 1);
        System.out.println(testAll.get(1));
        testAll.put(2, 2);
        testAll.put(3, 3);
        testAll.put(4, 4);
        testAll.put(4, 5);
        System.out.println(testAll.get(1));
        System.out.println(testAll.get(2));
        testAll.put(5, 5);
        System.out.println(testAll.get(2));


    }
}

//继承LinkedHashMap
class LRUCache extends LinkedHashMap<Integer, Integer> {
    Integer capacity;

    LRUCache(int capacity) {
        super(capacity, 0.75f);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }
}

class LRUCache2 {
    class Node {
        Integer key;
        Integer value;
        Node prev;
        Node next;

        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    Integer capacity;
    Integer size;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    LRUCache2(Integer capacity) {
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>();

        head = new Node(-2, null);
        tail = new Node(-2, null);

        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public Node removeLast() {
        Node last = tail.prev;
        if (last == head)
            return null;
        remove(last);
        return last;
    }

    public void moveToFirst(Node node) {
        remove(node);
        addFirst(node);
    }

    int get(int key) {
        Node node = map.get(key);
        if (node == null)
            return -1;
        moveToFirst(node);
        return node.value;
    }

    void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToFirst(node);
        } else {
            Node newNode = new Node(key, value);
            addFirst(newNode);
            map.put(key, newNode);
            size++;
            if (size > capacity) {
                Node last = removeLast();
                map.remove(last.key);
                size--;
            }
        }
    }


}
