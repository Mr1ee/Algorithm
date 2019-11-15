package fresh.lee.algorithm.java.design_pattern.observer;

public interface ISubject {

    void attach(Observer observer);

    void detach(Observer observer);

    void update();

    String event();
}
