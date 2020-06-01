package fresh.lee.algorithm.java.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    public static AtomicInteger race = new AtomicInteger(0);

    public static void increase() {
        race.incrementAndGet();
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int i1 = 0; i1 < 10000; ++i1) {
                    increase();
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 3)
            Thread.yield();
        System.out.println(race);
    }
}
