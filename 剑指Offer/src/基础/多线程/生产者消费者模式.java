package 基础.多线程;

import java.util.LinkedList;
import java.util.Queue;

//或者直接用LinkedBlockingQueue的put，take方法
public class 生产者消费者模式 {
    public static void main(String[] args) {
        int size=5;
        Queue<Product> productQueue=new LinkedList<>();
        Thread t1=new Thread(new Producer(size,productQueue));
        Thread t2=new Thread(new Customer(productQueue));
        t1.start();
        t2.start();
    }
}

class Product {
}

class Producer implements Runnable {
    private final int MAX_SIZE;
    private Queue<Product> queue;
    private Product product;

    Producer(int MAX_SIZE, Queue<Product> queue) {
        this.MAX_SIZE = MAX_SIZE;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == MAX_SIZE) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.offer(new Product());
                queue.notifyAll();
            }
        }
    }
}

class Customer implements Runnable {
    private Queue<Product> queue;
    private Product product;

    Customer(Queue<Product> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Product product = queue.poll();
                queue.notifyAll();
            }
        }
    }
}