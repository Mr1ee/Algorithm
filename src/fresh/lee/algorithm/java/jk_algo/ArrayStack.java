package fresh.lee.algorithm.java.jk_algo;

public class ArrayStack<T> implements IStack<T> {
    private static final int DEFAULT_SIZE = 4;
    private int capacity;
    private float factor = 0.5f;
    private int size;
    private T[] array;

    public ArrayStack() {
        this(DEFAULT_SIZE);
    }

    @SuppressWarnings("unchecked cast")
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        array = (T[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked cast")
    @Override
    public boolean push(T val) {
        //扩容
        if (size == capacity) {
            capacity = (int) (capacity * (1 + factor));
            T[] newArray = (T[]) new Object[capacity];
            System.out.println("动态扩充， capacity = " + capacity);
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }

        array[size++] = val;
        return true;
    }

    @Override
    public T pop() {
        if (size == 0) {
            return null;
        }

        T val = array[--size];
        //prevent memory leak!!!
        array[size] = null;
        return val;
    }

    @Override
    public T top() {
        if (size == 0) {
            return null;
        }
        return array[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }
}
