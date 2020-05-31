package fresh.lee.algorithm.java.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阻塞队列，{@link java.util.concurrent.ArrayBlockingQueue}
 */
public class ConditionQueue<T> {
    //队列元素列表
    private volatile Object[] elements;

    private Lock lock = new ReentrantLock();

    // 队列是否为空
    private Condition notEmpty = lock.newCondition();

    // 队列是否已满
    private Condition notFull = lock.newCondition();

    private int addIndex = 0, removeIndex = 0;
    public int length = 0;

    public ConditionQueue(int size) {
        elements = new Object[size];
    }

    // 插入元素，队列为满时则等待。
    public void put(T obj) throws InterruptedException {
        System.out.println("put " + obj);
        final Lock lock = this.lock;
        lock.lock();
        try {
            while (length == elements.length) {
                System.out.println("队列已满，请等待...");
                notFull.await();
            }
            enqueue(obj);
        } finally {
            lock.unlock();
        }
    }

    private void enqueue(T obj) {
        final Object[] items = this.elements;
        items[addIndex] = obj;
        if (++addIndex == items.length) {
            addIndex = 0;
        }
        length++;
        notEmpty.signal();
    }

    // 取元素，队列为空时等待
    @SuppressWarnings("unchecked")
    public T take() throws InterruptedException {
        final Lock lock = this.lock;
        lock.lock();
        try {
            while (0 == length) {
                System.out.println("队列为空，请等待...");
                notEmpty.await();
            }
            Object obj = elements[removeIndex++];
            if (removeIndex == elements.length) {
                removeIndex = 0;
            }
            length--;
            notFull.signal();
            return (T) obj;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ConditionQueue<String> queue = new ConditionQueue<>(3);
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                takeOnce(queue);
            }
        }).start();

        new Thread(() -> {
            try {
                queue.put("hello");
                queue.put("world");
                queue.put("java");
                queue.put("kotlin");
                queue.put("dart");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

    }

    private static void takeOnce(ConditionQueue<String> queue) {
        try {
            String take1 = queue.take();
            System.out.println("take = " + take1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
