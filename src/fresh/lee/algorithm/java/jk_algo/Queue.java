package fresh.lee.algorithm.java.jk_algo;

/**
 * 基于链表的队列
 * @param <T>
 */
public class Queue<T> implements IQueue<T> {

    private Node<T> head;
    private Node<T> tail;
    private Node<T> guard = new Node<>();

    public Queue() {
        head = null;
        tail = null;
    }

    @Override
    public boolean enqueue(T val) {
        Node<T> node = new Node<>(val);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = new Node<>(val);
            tail = tail.next;
        }
        return true;
    }

    @Override
    public T dequeue() {
        if (head == null) {
            return null;
        }
        T val = head.value;
        head = head.next;
        return val;
    }

    @Override
    public int size() {
        int size = 0;
        Node<T> p = head;
        while (p != tail) {
            size++;
            p = p.next;
        }
        return size;
    }

    @Override
    public void printQueue() {
        System.out.println("print queue:");

        Node<T> p = head;
        while (p != tail) {
            System.out.print(p.value + "  ");
            p = p.next;
        }

        System.out.println(tail.value);
    }
}
