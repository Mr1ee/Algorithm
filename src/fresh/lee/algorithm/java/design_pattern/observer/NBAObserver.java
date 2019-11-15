package fresh.lee.algorithm.java.design_pattern.observer;

public class NBAObserver extends Observer {
    public NBAObserver(String name, ISubject sub) {
        super(name, sub);
    }

    @Override
    void update() {
        System.out.println(sub.event() + ", " + name + " 关闭NBA直播,继续工作!");
    }
}
