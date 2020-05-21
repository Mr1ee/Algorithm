package fresh.lee.algorithm.kotlin.thread.p2c;

import java.util.LinkedList;

/**
 * 生产者和消费者的问题
 * wait、notify/notifyAll() 实现
 */
public class Storage1 implements AbstractStorage {
    //仓库最大容量
    private final int MAX_SIZE = 100;
    //仓库存储的载体
    private LinkedList list = new LinkedList();

    //生产产品
    public void produce(int num) {
        //同步
        synchronized (list) {
            String str = "【开始生产】";
            //仓库剩余的容量不足以存放即将要生产的数量，暂停生产
            while (list.size() + num > MAX_SIZE) {
                System.out.println(str + "【要生产的产品数量】:" + num + "\t【库存量】:"
                        + list.size() + "\t暂时不能执行生产任务!");

                str = "【再次开始生产】";
                try {
                    //条件不满足，生产阻塞
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < num; i++) {
                list.add(new Object());
            }

            System.out.println(str + "【已经生产产品数】:" + num + "\t【现仓储量为】:" + list.size());

            list.notifyAll();
        }
    }

    //消费产品
    public void consume(int num) {
        synchronized (list) {
            String str = "【开始消费】";
            //不满足消费条件
            while (num > list.size()) {
                System.out.println(str + "【要消费的产品数量】:" + num + "\t【库存量】:"
                        + list.size() + "\t暂时不能执行消费任务!");

                str = "【再次开始消费】";
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //消费条件满足，开始消费
            for (int i = 0; i < num; i++) {
                list.remove();
            }

            System.out.println(str + "【已经消费产品数】:" + num + "\t【现仓储量为】:" + list.size());

            list.notifyAll();
        }
    }
}