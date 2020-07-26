package 基础.多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 多线程交替打印2 {
    public static final int times = 5;

    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        Condition lockA = lock.newCondition();
        Condition lockB = lock.newCondition();
        new Thread(new Printer(lock,lockA,lockB,"A")).start();
        new Thread(new Printer(lock,lockB,lockA,"B")).start();
    }

    static class Printer implements Runnable {
        Lock lock;
        Condition thisLock;
        Condition nextLock;
        final String task;

        public Printer(Lock lock, Condition thisLock, Condition nextLock, String task) {
            this.lock = lock;
            this.thisLock = thisLock;
            this.nextLock = nextLock;
            this.task = task;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < times; i++) {
                    thisLock.signal();
                    System.out.println(task);
                    if (i < times - 1) {
                        nextLock.await();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}




