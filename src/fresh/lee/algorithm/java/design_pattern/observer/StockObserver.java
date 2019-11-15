package fresh.lee.algorithm.java.design_pattern.observer;

public class StockObserver extends Observer {

    public StockObserver(String name, ISubject sub) {
        super(name, sub);
    }

    @Override
    void update() {
        System.out.println(sub.event() + ", " + name + " 关闭股票行情,继续工作!");
    }
}
