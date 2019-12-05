package fresh.lee.algorithm.java.jk_algo;

public class QueueMain {

    public static void main(String[] args) {
        IQueue<String> queue = new ArrayQueue<>();

        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");

        queue.printQueue();
        System.out.println("dequeue : " + queue.dequeue());
        queue.printQueue();

        queue.enqueue("e");
        queue.enqueue("f");
        queue.printQueue();
    }
}
