package fresh.lee.algorithm.java.design_pattern.iterator;

import java.util.Iterator;

/**
 * 晚餐菜单
 */
public class DinnerMenu implements Menu<MenuItem> {
    private static final int MAX_LENGTH = 6;
    private MenuItem[] menuItems;
    private int numberOfItems = 0;

    public DinnerMenu() {
        this.menuItems = new MenuItem[MAX_LENGTH];
        //lettuce 莴苣 生菜
        //relish 酱汁
        //saurkraut 酸菜
        //cheese 奶酪
        addItem("Vegetarian BLT", "(Facin') bacon with lettuce & tomato on whole wheat", true, 2.99);
        addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99);
        addItem("Soup of the Day", "Soup of the day, with a slide of potato salad", false, 3.29);
        addItem("Hotdog", "A Hotdog, with a saurkraut, relish, onions, topped with cheese", false, 3.05);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem item = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems > MAX_LENGTH) {
            throw new IllegalArgumentException("menu only support " + MAX_LENGTH + " items!");
        } else {
            menuItems[numberOfItems] = item;
            numberOfItems++;
        }
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return new DinnerMenuIterator(menuItems);
    }
}
