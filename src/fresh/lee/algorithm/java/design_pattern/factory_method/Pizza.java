package fresh.lee.algorithm.java.design_pattern.factory_method;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    List<String> toppings = new ArrayList<>();

    void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...  ");
        System.out.println("Adding sauce...  ");
        System.out.print("Adding toppings:  ");

        for (String topping : toppings) {
            System.out.println(topping + " ");
        }
    }

    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }

    public enum Type {
        CHEESE("cheese"), PEPERONI("peperoni"), CLAM("clam"), VEGGLE("veggle");
        private final String type;

        Type(String type) {
            this.type = type;
        }
    }

}
