package fresh.lee.algorithm.java.design_pattern.factory_method;

public class NyStyleVegglePizza extends Pizza {
    public NyStyleVegglePizza() {
        name = "NewYork style veggle pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
    }

    @Override
    void cut() {
        System.out.println("Cutting the pizza into rectangle");
    }
}
