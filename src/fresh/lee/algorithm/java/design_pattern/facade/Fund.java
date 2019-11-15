package fresh.lee.algorithm.java.design_pattern.facade;

/**
 * 基金类 相当于外观模式（Facade）的外观类，对外提供接口，隐藏内部细节
 */
public class Fund implements IProduct {
    IProduct stock1;
    IProduct stock2;
    IProduct stock3;
    IProduct nationalDebt;
    IProduct realty;

    public Fund() {
        stock1 = new Stock("股票1");
        stock2 = new Stock("股票2");
        stock3 = new Stock("股票3");
        nationalDebt = new NationalDebt("国债1");
        realty = new Realty("房产1");
    }

    @Override
    public void buy() {
        stock1.buy();
        stock2.buy();
        stock3.buy();
        nationalDebt.buy();
        realty.buy();
    }

    @Override
    public void sell() {
        stock1.buy();
        stock2.buy();
        stock3.buy();
        nationalDebt.buy();
        realty.buy();
    }
}
