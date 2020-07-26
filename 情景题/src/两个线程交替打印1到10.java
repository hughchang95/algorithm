import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 两个线程交替打印1到10 {
    public static volatile int num = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        int count = 5;
        new Thread(new Print(count,lock, condition1, condition2)).start();
        new Thread(new Print(count,lock, condition2, condition1)).start();


    }

    static class Print implements Runnable {
        int count;
        ReentrantLock lock;
        Condition thislock;
        Condition prelock;

        public Print(int count, ReentrantLock lock, Condition thislock, Condition prelock) {
            this.count = count;
            this.lock = lock;
            this.thislock = thislock;
            this.prelock = prelock;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < count; i++) {
                    thislock.signal();
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num=num+1;
                    prelock.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
