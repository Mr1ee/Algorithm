package fresh.lee.algorithm.java.design_pattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PancakeHouseMenu implements Menu<MenuItem> {
    private List<MenuItem> menuItems;


    public PancakeHouseMenu() {
        menuItems = new ArrayList<>();

        addItem("K&B Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99);
        addItem("Regular Pancake Breakfast", "Pancakes with fried eggs, and sausage", false, 2.99);
        addItem("BlueBerry Pancake Breakfast", "Pancakes made with fresh blueberries", true, 3.49);
        addItem("Waffle", "Waffle ,with your choice of blueberries or strawberries", true, 3.49);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem item = new MenuItem(name, description, vegetarian, price);
        this.addItem(item);
    }

    public void addItem(MenuItem item) {
        menuItems.add(item);
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return menuItems.iterator();
    }
}
