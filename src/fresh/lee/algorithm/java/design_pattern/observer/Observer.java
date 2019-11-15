package fresh.lee.algorithm.java.design_pattern.observer;

public abstract class Observer {
    protected String name;
    protected ISubject sub;

    public Observer(String name, ISubject sub) {
        this.name = name;
        this.sub = sub;
    }

    abstract void update();
}
