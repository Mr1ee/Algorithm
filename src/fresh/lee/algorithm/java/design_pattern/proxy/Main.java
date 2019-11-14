package fresh.lee.algorithm.java.design_pattern.proxy;

public class Main {

    /**
     * 代理模式，为其他对象提供一种代理以控制对这个对象的访问
     */
    public static void main(String[] args) {
        SchoolGirl jiaojiao = new SchoolGirl("娇娇");
        Proxy daili = new Proxy(jiaojiao);
        daili.giveDolls();
        daili.giveFlowers();
        daili.giveChocolate();
    }
}
