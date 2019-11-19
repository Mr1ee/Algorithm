package fresh.lee.algorithm.java.design_pattern.iterator;

/**
 * 菜单项 类
 */
public class MenuItem {

    private String name;
    private String description;
    private boolean vegetarian;
    private double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ", " + price + " -- " + description;
    }
}
