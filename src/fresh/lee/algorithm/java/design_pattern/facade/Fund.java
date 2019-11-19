package fresh.lee.algorithm.java.design_pattern.facade;

import java.util.ArrayList;
import java.util.List;

/**
 * 基金类 相当于外观模式（Facade）的外观类，对外提供接口，隐藏内部细节
 */
public class Fund implements IProduct {
    //    IProduct stock1;
//    IProduct stock2;
//    IProduct stock3;
//    IProduct nationalDebt;
//    IProduct realty;
    List<IProduct> products = new ArrayList<>();

    public Fund() {
//        stock1 = new Stock("股票1");
//        stock2 = new Stock("股票2");
//        stock3 = new Stock("股票3");
//        nationalDebt = new NationalDebt("国债1");
//        realty = new Realty("房产1");
        products.add(new Stock("股票1"));
        products.add(new Stock("股票2"));
        products.add(new Stock("股票3"));
        products.add(new NationalDebt("国债1"));
        products.add(new Realty("房产1"));
    }

    @Override
    public void buy() {
//        stock1.buy();
//        stock2.buy();
//        stock3.buy();
//        nationalDebt.buy();
//        realty.buy();
        for (IProduct product : products) {
            product.buy();
        }
    }

    public void addProduct(IProduct product) {
        this.products.add(product);
    }

    public List<IProduct> getProducts() {
        return products;
    }

    @Override
    public void sell() {
//        stock1.buy();
//        stock2.buy();
//        stock3.buy();
//        nationalDebt.buy();
//        realty.buy();
        for (IProduct product : products) {
            product.sell();
        }
    }
}
