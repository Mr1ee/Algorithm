package fresh.lee.algorithm.java.jk_algo;

public class Node<T> {
    public Node() {
    }

    public Node(T value) {
        next = null;
        this.value = value;
    }

    public Node<T> next;
    public T value;
}
