package fresh.lee.algorithm.java.design_pattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 服务员
 */
public class Waitress {
    //    private PancakeHouseMenu pancakeHouseMenu;
//    private DinnerMenu dinnerMenu;
    private final List<Menu<MenuItem>> menuItemList;

    public Waitress() {
        this.menuItemList = new ArrayList<>();
    }

//    public Waitress(PancakeHouseMenu pancakeHouseMenu, DinnerMenu dinnerMenu) {
//        this.pancakeHouseMenu = pancakeHouseMenu;
//        this.dinnerMenu = dinnerMenu;
//    }

    public void addMenu(Menu<MenuItem> menu) {
        this.menuItemList.add(menu);
    }

    public void printAllMenu() {
//        Iterator<MenuItem> pancakeMenuIterator = pancakeHouseMenu.createIterator();
//        Iterator<MenuItem> dinnerMenuIterator = dinnerMenu.createIterator();
        for (Menu<MenuItem> menu : menuItemList) {
            System.out.println("\n----------" + menu.getClass().getSimpleName() + "----------");
            printMenu(menu);
        }
    }

    public void printMenu(Menu<MenuItem> menu) {
        Iterator<MenuItem> itemIterator = menu.createIterator();
        while (itemIterator.hasNext()) {
            MenuItem item = itemIterator.next();
            System.out.println(item);
        }
    }
}
