package fresh.lee.algorithm.java.jksj_algo;

public interface IQueue<T> {

    /**
     * 进队列
     */
    boolean enqueue(T val);

    /**
     * 出队列
     */
    T dequeue();

    /**
     * @return queue size
     */
    int size();

    void printQueue();
}
