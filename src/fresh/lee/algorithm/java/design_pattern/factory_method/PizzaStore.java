package fresh.lee.algorithm.java.design_pattern.factory_method;

public abstract class PizzaStore {

    public Pizza orderPizza(Pizza.Type type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    abstract Pizza createPizza(Pizza.Type type);
}
