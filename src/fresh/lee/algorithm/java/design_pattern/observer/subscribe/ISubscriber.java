package fresh.lee.algorithm.java.design_pattern.observer.subscribe;

/**
 * 订阅者
 */
public interface ISubscriber<T> extends ITopic {
    void update(T data);
}
