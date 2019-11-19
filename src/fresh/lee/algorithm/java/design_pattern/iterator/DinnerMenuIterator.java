package fresh.lee.algorithm.java.design_pattern.iterator;

import java.util.Iterator;

/**
 * 将不支持iterator功能的数组封装成Iterator
 */
public class DinnerMenuIterator implements Iterator<MenuItem> {
    private MenuItem[] menuItems;
    private int position = 0;

    public DinnerMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return menuItems != null && position < menuItems.length && menuItems[position] != null;
    }

    @Override
    public MenuItem next() {
        MenuItem item = menuItems[position];
        position++;
        return item;
    }

    @Override
    public void remove() {
        if (position < 0) {
            throw new IllegalArgumentException("You can't remove an item until you've done at least one next()!");
        }

        if (menuItems[position] != null) {
            if (menuItems.length - 1 - position - 1 >= 0)
                System.arraycopy(menuItems, position, menuItems, position - 1, menuItems.length - 1 - position - 1);

            menuItems[menuItems.length - 1] = null;
        }
    }
}
