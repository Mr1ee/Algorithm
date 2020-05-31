package fresh.lee.algorithm.java.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch典型用法：
 * 1、某一线程在开始运行前等待n个线程执行完毕。将CountDownLatch的计数器初始化为new CountDownLatch(n)，
 * 每当一个任务线程执行完毕，就将计数器减1 countdownLatch.countDown()，当计数器的值变为0时，
 * 在CountDownLatch上await()的线程就会被唤醒。一个典型应用场景就是启动一个服务时，主线程需要等待多个组件
 * 加载完毕，之后再继续执行。
 * <p>
 * 2、实现多个线程开始执行任务的最大并行性。注意是并行性，不是并发，强调的是多个线程在某一时刻同时开始执行。
 * 类似于赛跑，将多个线程放到起点，等待发令枪响，然后同时开跑。做法是初始化一个共享的CountDownLatch(1)，
 * 将其计算器初始化为1，多个线程在开始执行任务前首先CountDownLatch.await()，当主线程调用countDown()时，
 * 计数器变为0，多个线程同时被唤醒。
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        System.out.println("CountDownLatch 测试1：等待所有玩家准备好游戏开始！🎮");
        test1();
        System.out.println("\nCountDownLatch 测试2：赛跑🏃！");
        test2();
    }

    public static void test1() {
        ExecutorService service = Executors.newFixedThreadPool(3);
        final CountDownLatch latch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            Runnable runnable = () -> {
                try {
                    System.out.println("player " + Thread.currentThread().getName() + "开始准备");
                    long t0 = System.currentTimeMillis();
                    Thread.sleep((long) (Math.random() * 3000));
                    long t1 = System.currentTimeMillis();
                    System.out.println("player " + Thread.currentThread().getName() + "准备好了，用时：" + (t1 - t0) + "ms");
                    latch.countDown();//当前线程调用此方法，则计数减一
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            service.execute(runnable);
        }

        try {
            System.out.println("游戏：" + Thread.currentThread().getName() + "正在等待所有玩家准备好...");
            latch.await();//阻塞当前线程，直到计数器的值为0
            System.out.println("游戏" + Thread.currentThread().getName() + "玩家都准备好了，开始游戏...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }

    private static void test2() {
        ExecutorService service = Executors.newCachedThreadPool();
        final CountDownLatch cdOrder = new CountDownLatch(1);
        final CountDownLatch cdAnswer = new CountDownLatch(4);
        for (int i = 0; i < 4; i++) {
            Runnable runnable = () -> {
                try {
                    System.out.println("选手" + Thread.currentThread().getName() + "正在等待裁判发布口令");
                    cdOrder.await();
                    long t0 = System.currentTimeMillis();
                    System.out.println("选手" + Thread.currentThread().getName() + "，在时刻：" + t0 + "接受裁判口令");
                    Thread.sleep((long) (Math.random() * 3000));
                    long t1 = System.currentTimeMillis();
                    System.out.println("选手" + Thread.currentThread().getName() + "到达终点，用时：" + (t1 - t0));
                    cdAnswer.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            service.execute(runnable);
        }
        try {
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println("裁判" + Thread.currentThread().getName() + "即将发布口令");
            cdOrder.countDown();
            long t0 = System.currentTimeMillis();
            System.out.println("裁判" + Thread.currentThread().getName() + "在时刻：" + t0 + "发送口令，正在等待所有选手到达终点");
            cdAnswer.await();
            System.out.println("所有选手都到达终点");
            System.out.println("裁判" + Thread.currentThread().getName() + "汇总成绩排名");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
