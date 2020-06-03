package fresh.lee.algorithm.java.thread;

public class ThreadJoinTest {
    static class ChildThread extends Thread {
        long timeout = 1000;
        volatile static int count = 0;

        public ChildThread(String name, long timeout) {
            this(name, timeout, null);
        }

        public ChildThread(String name, long timeout, Runnable runnable) {
            super(runnable, name);
            this.timeout = timeout;
        }

        @Override
        public void run() {
            super.run();
            // do something
            try {
                System.out.println(getName() + "开始做事了,需要工作" + timeout / 1000 + "小时");
                Thread.sleep(timeout);
                System.out.println(getName() + "工作完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ChildThread childThread = new ChildThread("路人甲", 1000);
        ChildThread childThread2 = new ChildThread("路人乙", 3000);
        childThread.start();
        childThread2.start();
        childThread.join();
        childThread2.join();
        System.out.println("父线程继续...");
    }
}
