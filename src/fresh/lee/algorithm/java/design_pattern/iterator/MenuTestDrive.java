package fresh.lee.algorithm.java.design_pattern.iterator;

public class MenuTestDrive {

    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinnerMenu dinnerMenu = new DinnerMenu();
        CafeMenu cafeMenu = new CafeMenu();

        Waitress waitress = new Waitress();
        waitress.addMenu(pancakeHouseMenu);
        waitress.addMenu(dinnerMenu);
        waitress.addMenu(cafeMenu);

        waitress.printAllMenu();
    }
}
