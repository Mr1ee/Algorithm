package fresh.lee.algorithm.java.singleton;

/**
 * 懒汉模式：，不能应用多线程
 * 懒汉模式在方法被调用后才创建对象，以时间换空间，在多线程环境下存在风险。
 */
public class Singleton2 {

    //私有构造函数
    private Singleton2() {

    }

    private static Singleton2 sInstance = null;

    //公有Get方法
    public static Singleton2 getInstance() {
        if (sInstance == null) {
            sInstance = new Singleton2();
        }

        return sInstance;
    }

}