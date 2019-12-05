package fresh.lee.algorithm.java.jk_algo;

/**
 * 循环队列
 * 注意这里浪费了一个空间
 *
 * @param <T>
 */
public class CircleQueue<T> implements IQueue<T> {

    private static final int DEFAULT_SIZE = 6;
    private int capacity;
    private int head;
    private int tail;
    private T[] array;

    public CircleQueue() {
        this(DEFAULT_SIZE);
    }

    @SuppressWarnings("unchecked cast")
    public CircleQueue(int capacity) {
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
        array = (T[]) new Object[capacity];
    }

    @Override
    public boolean enqueue(T val) {
        //队列满了
        if (tail + 1 % capacity == head) {
            return false;
        }

        array[tail] = val;
        tail = (tail + 1) % capacity;

        return true;
    }

    @Override
    public T dequeue() {
        if (head == tail) {
            return null;
        }

        T val = array[head];
        head = (head + 1) % capacity;
        return val;
    }

    @Override
    public int size() {
        return (tail + capacity - head) % capacity;
    }

    @Override
    public void printQueue() {
        System.out.println("print queue:");
        System.out.println("head = " + head + "  tail = " + tail);
        int size = this.size();
        for (int i = 0; i < size; i++) {
            System.out.print(array[(head + i) % capacity] + "  ");
        }

        System.out.println();
    }
}
