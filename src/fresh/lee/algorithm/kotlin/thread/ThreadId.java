package fresh.lee.algorithm.kotlin.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadId {

    private static final AtomicInteger nextId = new AtomicInteger(1);

    private ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return nextId.getAndIncrement();
        }
    };

    public int get() {
        return threadId.get();
    }

    public void set(int value) {
        threadId.set(value);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                ThreadId threadId = new ThreadId();
                System.out.println("i= " + finalI + ", before set, id = " + threadId.get());
                threadId.set(threadId.get() * 2);
                System.out.println("i= " + finalI + ", after set, id = " + threadId.get());

            }).start();
        }
    }
}