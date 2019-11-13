package fresh.lee.algorithm.java.design_pattern.singleton;

/**
 * 双重锁懒汉模式(Double Check Lock)
 * DCL模式的优点就是，只有在对象需要被使用时才创建，第一次判断 INSTANCE == null为了避免非必要加锁，
 * 当第一次加载时才对实例进行加锁再实例化。这样既可以节约内存空间，又可以保证线程安全。
 * 但是，由于jvm存在乱序执行功能，DCL也会出现线程不安全的情况。
 * 解决办法：JDK1.6之后，添加volatile 关键字，确保INSTANCE每次均在主内存中读取
 */
public class Singleton3 {

    //私有构造函数
    private Singleton3() {

    }

    //私有静态属性
//    private static Singleton3 sInstance = new Singleton3();
    private volatile static Singleton3 sInstance = new Singleton3();

    //公有Get方法，双重检验，方法内部加锁，避免非必要加锁
    public static Singleton3 getInstance() {
        if (sInstance == null) {
            synchronized (Singleton3.class) {
                if (sInstance == null) {
                    sInstance = new Singleton3();
                }
            }
        }
        return sInstance;
    }

    //公有Get方法，给整个方法加锁，每次都要调用都要加锁，并发行很差
    public static synchronized Singleton3 getInstance2() {
        if (sInstance == null) {
            sInstance = new Singleton3();
        }
        return sInstance;
    }
}
