package fresh.lee.algorithm.java.jk_algo;

public class Queue<T> implements IQueue<T> {

    private Node<T> head;
    private Node<T> tail;

    public Queue() {
        head = new Node<>();
        tail = new Node<>();
    }

    @Override
    public boolean enqueue(T val) {
        tail.next = new Node<>(val);
        return false;
    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void printQueue() {

    }
}
