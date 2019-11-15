package fresh.lee.algorithm.java.design_pattern.facade;

public class Realty implements IProduct {

    private String name;

    public Realty(String name) {
        this.name = name;
    }

    @Override
    public void buy() {
        System.out.println("购买房产:" + name);
    }

    @Override
    public void sell() {
        System.out.println("出售房产:" + name);
    }
}
