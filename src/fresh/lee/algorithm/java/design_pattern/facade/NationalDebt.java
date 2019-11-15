package fresh.lee.algorithm.java.design_pattern.facade;

public class NationalDebt implements IProduct {

    private String name;

    public NationalDebt(String name) {
        this.name = name;
    }
    @Override
    public void buy() {
        System.out.println("购买国债:" + name);

    }

    @Override
    public void sell() {
        System.out.println("出售国债:" + name);
    }
}
