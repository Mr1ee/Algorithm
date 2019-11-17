package fresh.lee.algorithm.java.design_pattern.observer.subscribe;

/**
 * 发布者
 */
public interface IPublisher<T> {
    void addSubscriber(ISubscriber<T> subscriber);

    void removeSubscriber(ISubscriber<T> subscriber);

    void notifyDataChanged();
}
