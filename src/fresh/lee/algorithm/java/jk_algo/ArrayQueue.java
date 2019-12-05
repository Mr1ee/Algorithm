package fresh.lee.algorithm.java.jk_algo;

public class ArrayQueue<T> implements IQueue<T> {

    private static final int DEFAULT_SIZE = 10;
    private int capacity;
    private float factor = 0.5f;
    private int head;
    private int tail;
    private T[] array;

    public ArrayQueue() {
        this(DEFAULT_SIZE);
    }

    @SuppressWarnings("unchecked cast")
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
        array = (T[]) new Object[capacity];
    }

    @Override
    public boolean enqueue(T val) {
        if (tail == capacity) {
            if (head == 0) {
                return false;
            }

            // 数据搬移
            if (tail - head >= 0) {
                System.arraycopy(array, head, array, 0, tail - head);
            }
            tail -= head;
            head = 0;
        }

        array[tail++] = val;
        return true;
    }

    @Override
    public T dequeue() {
        if (head == tail) {
            return null;
        }
//        array[head++] = null;
        return array[head++];
    }

    @Override
    public int size() {
        return head - tail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = head; i < tail; i++) {
            sb.append(array[i]).append("  ");
        }
        return sb.toString();
    }

    @Override
    public void printQueue() {
        System.out.println("print queue:");
        System.out.println(this.toString());
    }
}
