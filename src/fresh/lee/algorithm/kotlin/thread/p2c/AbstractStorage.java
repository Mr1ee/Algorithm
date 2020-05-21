package fresh.lee.algorithm.kotlin.thread.p2c;

/**
 * 抽象工厂
 */
public interface AbstractStorage {
    void consume(int num);
    void produce(int num);
}