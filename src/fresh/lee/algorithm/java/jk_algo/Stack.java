package fresh.lee.algorithm.java.jk_algo;

/**
 * 基于链表的栈
 */
public class Stack<T> implements IStack<T> {
    private Node<T> top;

    public Stack() {
        top = null;
    }

    @Override
    public boolean push(T val) {

        Node<T> node = new Node<>(val);
        node.next = top;
        top = node;

        return true;
    }

    @Override
    public T pop() {
        if (top == null) {
            throw new IllegalStateException("stack is empty~");
        }
        T val = top.value;
        top = top.next;
        return val;
    }

    @Override
    public T top() {
        if (top == null) {
            return null;
        }

        return top.value;
    }

    @Override
    public boolean isEmpty() {
        return top != null;
    }

    @Override
    public void printAll() {
        System.out.println("print all stack ");
        Node<T> p = top;
        while (p != null) {
            System.out.print(p.value + "  ");
            p = p.next;
        }
        System.out.println();
    }
}
