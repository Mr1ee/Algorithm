package fresh.lee.algorithm.java.design_pattern.factory;

/**
 * 简单工厂
 */
public class SimpleFactory {
    public Car createCarFactory(int num) {
        Car car;
        switch (num) {
            case 1:
                car = new Car("东风雪铁龙");
                break;
            case 2:
                car = new Car("东风雪铁龙", "红色");
                break;
            default:
                car = new Car();
                break;
        }
        return car;
    }
}
