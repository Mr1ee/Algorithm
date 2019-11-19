package fresh.lee.algorithm.java.design_pattern.facade;

public class Main {

    /**
     * 外观模式(Facade)，为子系统中的一组接口提供一个一致的界面，
     * 此模式定义了一个高层接口，此接口使得子系统更加容易使用
     */
    public static void main(String[] args) {
        IProduct fund = new Fund();
        fund.buy();
        fund.sell();
    }
}
