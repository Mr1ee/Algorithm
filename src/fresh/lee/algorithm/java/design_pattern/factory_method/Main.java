package fresh.lee.algorithm.java.design_pattern.factory_method;

public class Main {

    /**
     * OO原则：
     * 封装变化；
     * 多用组合（复合），少用继承；
     * 针对接口编程，不针对实现（细节）编程
     * 为交互对象之间的[松耦合]设计而努力
     * 对扩展开放，对修改关闭[开-闭原则]
     * 以来抽象。不要依赖于具体
     * * <p>
     * 工厂方法(factory method)模式定义了一个创建对象的接口，但由子类决定要实例化的类是哪一个。
     * 工厂方法让类的实例化推迟到子类
     */
    public static void main(String[] args) {

        PizzaStore nyPizzaStore = new NYPizzaStore();
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();

        Pizza pizza = nyPizzaStore.orderPizza(Pizza.Type.VEGGLE);
        System.out.println("xiao wang order " + pizza.getName());

        System.out.println();
        Pizza nyCheesePizza = nyPizzaStore.orderPizza(Pizza.Type.CHEESE);
        System.out.println("xiao zhang order " + nyCheesePizza.getName());

        System.out.println();
        Pizza chicagoPizza = chicagoPizzaStore.orderPizza(Pizza.Type.CHEESE);
        System.out.println("xiao ming order " + chicagoPizza.getName());
    }
}
