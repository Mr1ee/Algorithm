package fresh.lee.algorithm.java.design_pattern.observer;

public class Main {

    /**
     * 观察者模式(Observer)定义了一对多的依赖关系，让多个观察者对象同时监听一个主题对象。
     * 当这个对象状态发生变化时，会通知所有观察者。（或许写一个天气预报观察者的栗子更好）
     */
    public static void main(String[] args) {
        Secretary secretary = new Secretary();
        Observer stock1 = new StockObserver("张三", secretary);
        Observer stock2 = new StockObserver("李四", secretary);
        Observer stock3 = new StockObserver("魏关注", secretary);
        Observer nba1 = new NBAObserver("王五", secretary);
        secretary.attach(stock1);
        secretary.attach(stock2);
        secretary.attach(stock3);
        secretary.attach(nba1);

        secretary.setEvent("Boss走！");
        secretary.update();

        secretary.detach(stock3);
        secretary.setEvent("Boss回来了！");
        secretary.update();
    }
}
