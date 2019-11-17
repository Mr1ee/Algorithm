package fresh.lee.algorithm.java.design_pattern.factory_method;

public class NyStyleCheesePizza extends Pizza {
    public NyStyleCheesePizza() {
        name = "NewYork style sauce and cheese pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
    }
}
