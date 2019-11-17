package fresh.lee.algorithm.java.design_pattern.factory_method;

public class NyStyleClamPizza extends Pizza {

    public NyStyleClamPizza() {
        name = "NewYork style clam pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
    }
}
