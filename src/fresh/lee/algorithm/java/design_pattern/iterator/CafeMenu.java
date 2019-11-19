package fresh.lee.algorithm.java.design_pattern.iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CafeMenu implements Menu<MenuItem> {
    private Map<String, MenuItem> menuItems;

    public CafeMenu() {
        this.menuItems = new HashMap<>();
        //Burrito 墨西哥玉米煎饼
        //guacamole 墨西哥鳄梨酱(用碾碎的鳄梨加洋葱、番茄、辣椒等调制而成);
        addItem("Veggie Burger and Air Fries", "(Facin') bacon with lettuce & tomato on whole wheat", true, 2.99);
        addItem("Soup of the Day", "Soup of the day, with a slide of potato salad", false, 3.29);
        addItem("Burrito", "a large burrito , with whole into bins, salad, guacamole", true, 4.29);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem item = new MenuItem(name, description, vegetarian, price);
        this.addItem(item);
    }

    public void addItem(MenuItem item) {
        menuItems.put(item.getName(), item);
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return menuItems.values().iterator();
    }
}
