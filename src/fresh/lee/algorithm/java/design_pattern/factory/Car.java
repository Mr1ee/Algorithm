package fresh.lee.algorithm.java.design_pattern.factory;

/**
 * Car 基类
 */
public class Car {
    /**
     * 品牌
     */
    private String brand;

    /**
     * 颜色
     */
    private String color;

    public Car() {

    }

    public Car(String brand) {
        this.brand = brand;
    }

    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "[brand:" + brand + "]" + "," + "[color:" + color + "]";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
