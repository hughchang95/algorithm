package 基础.多线程;

public class 多线程交替打印 {
    private volatile int state = 0;
    private static Object lockObject = new Object();

    class PrintTask implements Runnable {

        private final int printCount;
        private final String content;


        private int thisPrint;
        private int nextPrint;

        public PrintTask(int printCount, String content, int thisPrint, int nextPrint) {
            this.printCount = printCount;
            this.content = content;
            this.thisPrint = thisPrint;
            this.nextPrint = nextPrint;
        }


        @Override
        public void run() {
            synchronized (lockObject) {
                for (int i = 0; i < printCount; i++) {
                    while (state != thisPrint) {
                        try {
                            lockObject.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(content);
                    state = nextPrint;
                    lockObject.notifyAll();
                }
            }
        }

    }

    public void test() throws InterruptedException {
        int count = 10;
        PrintTask p1 = new PrintTask(count, "A", 0, 1);
        PrintTask p2 = new PrintTask(count, "B", 1, 2);
        PrintTask p3 = new PrintTask(count, "C", 2, 0);
        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(p3).start();
    }

    public static void main(String[] args) throws InterruptedException {
        多线程交替打印 a = new 多线程交替打印();
        a.test();
    }
}

