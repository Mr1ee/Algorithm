package fresh.lee.algorithm.java.jz_offer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <h3>Exper1</h3>
 * <p>ThreadLocalId</p>
 *
 * @author : cxc
 * @date : 2020-04-01 23:48
 **/
public class ThreadLocalId {
    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);
    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(() -> nextId.getAndIncrement());

    // Returns the current thread's unique ID, assigning it if necessary
    public static int get() {
        return threadId.get();
    }

    public static void remove() {
        threadId.remove();
    }
}