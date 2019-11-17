package fresh.lee.algorithm.java.design_pattern.factory_method;

public class Main {

    /**
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
