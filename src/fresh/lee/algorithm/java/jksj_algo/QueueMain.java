package fresh.lee.algorithm.java.jksj_algo;

public class QueueMain {

    public static void main(String[] args) {
        IQueue<String> queue = new Queue<>();

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

        System.out.println("\nCircle Queue");
        IQueue<String> circleQueue = new CircleQueue<>();
        circleQueue.enqueue("a");
        circleQueue.enqueue("b");
        circleQueue.enqueue("c");
        circleQueue.enqueue("d");
        circleQueue.printQueue();
        circleQueue.dequeue();
        circleQueue.dequeue();
        circleQueue.printQueue();

        circleQueue.enqueue("e");
        System.out.println("enqueue f: " + circleQueue.enqueue("f"));
        System.out.println("enqueue g: " +circleQueue.enqueue("g"));
        circleQueue.printQueue();

        System.out.println("enqueue h: " +circleQueue.enqueue("h"));
        circleQueue.printQueue();

        circleQueue.dequeue();
        circleQueue.printQueue();

        System.out.println("enqueue h: " +circleQueue.enqueue("h"));
        circleQueue.printQueue();

    }
}
