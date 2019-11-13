package fresh.lee.algorithm.java.design_pattern.singleton;

/**
 * 饿汉单例模式，
 * 饿汉模式在类被初始化时就已经在内存中创建了对象，以空间换时间，故不存在线程安全问题。
 */
public class Singleton1 {

    //私有构造函数
    private Singleton1(){

    }

    //私有静态属性
    private static Singleton1 sInstance = new Singleton1();

    //共有Get方法
    public static Singleton1 getInstance(){
        return sInstance;
    }

}
