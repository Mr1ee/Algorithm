package fresh.lee.algorithm.java.design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Secretary implements ISubject {

    private String event;

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void update() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public String event() {
        return event;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
