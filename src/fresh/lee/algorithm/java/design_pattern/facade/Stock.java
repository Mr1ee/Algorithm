package fresh.lee.algorithm.java.design_pattern.facade;

public class Stock implements IProduct {

    private String name;

    public Stock(String name) {
        this.name = name;
    }

    @Override
    public void buy() {
        System.out.println("购买股票:" + name);
    }

    @Override
    public void sell() {
        System.out.println("出售股票:" + name);
    }
}
