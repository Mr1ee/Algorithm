package fresh.lee.algorithm.java.design_pattern.factory_method;

public class NYPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(Pizza.Type type) {
        Pizza pizza;
        switch (type) {
            case CLAM:
                pizza = new NyStyleCheesePizza();
                break;
            case CHEESE:
                pizza = new NyStyleCheesePizza();
                break;
            case VEGGLE:
                pizza = new NyStyleVegglePizza();
                break;
            case PEPERONI:
                pizza = new NyStyleCheesePizza();
                break;
            default:
                pizza = new NyStyleCheesePizza();
        }
        return pizza;
    }
}
