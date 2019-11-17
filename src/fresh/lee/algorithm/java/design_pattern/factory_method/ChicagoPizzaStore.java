package fresh.lee.algorithm.java.design_pattern.factory_method;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(Pizza.Type type) {
        Pizza pizza;
        switch (type) {
            case CLAM:
                pizza = new ChicogoStyleCheesePizza();
                break;
            case CHEESE:
                pizza = new ChicogoStyleCheesePizza();
                break;
            case VEGGLE:
                pizza = new ChicogoStyleCheesePizza();
                break;
            case PEPERONI:
                pizza = new ChicogoStyleCheesePizza();
                break;
            default:
                pizza = new ChicogoStyleCheesePizza();
        }
        return pizza;
    }
}
