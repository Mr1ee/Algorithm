package fresh.lee.algorithm.kotlin.thread;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {
    private Data load;

    public Receiver(Data data) {
        load = data;
    }

    // standard constructors

    public void run() {
        for (String receivedMessage = load.receive(); !"End".equals(receivedMessage); receivedMessage = load.receive()) {

            System.out.println(receivedMessage);

            // ...
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 500));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
//                Log.error("Thread interrupted", e);
            }
        }
    }
}