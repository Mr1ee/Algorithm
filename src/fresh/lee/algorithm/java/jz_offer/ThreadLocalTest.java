package fresh.lee.algorithm.java.jz_offer;

public class ThreadLocalTest {

    private static void incrementSameThreadId() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread()
                        + "_" + i + ",threadId:" +
                        ThreadLocalId.get());
            }
        } finally {
            ThreadLocalId.remove();
        }
    }
    public static void main(String[] args) {
        incrementSameThreadId();
        incrementSameThreadId();

        new Thread(new Runnable() {
            @Override
            public void run() {
                incrementSameThreadId();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                incrementSameThreadId();
            }
        }).start();
    }
}
