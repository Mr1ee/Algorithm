package fresh.lee.algorithm.java.design_pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

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

        DynamicProxy<Action> gfsDL = new DynamicProxy();
        Action lurenJia = new Pursuit(jiaojiao);
        Action gfs = gfsDL.newProxyInstance(lurenJia);
        Action gfs2 = (Action) java.lang.reflect.Proxy.newProxyInstance(lurenJia.getClass().getClassLoader(), lurenJia.getClass().getInterfaces(),
                (o, method, objects) -> {
                    System.out.println("我是路人甲的代理，代理了：" + method.getName() + "方法");
                    return method.invoke(lurenJia, objects);
                });
        gfs.giveDolls();
        gfs.giveFlowers();
        gfs.giveChocolate();

        gfs2.giveDolls();
        gfs2.giveFlowers();
        gfs2.giveChocolate();
    }
}
