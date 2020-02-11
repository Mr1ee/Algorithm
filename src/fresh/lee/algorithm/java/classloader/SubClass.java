package fresh.lee.algorithm.java.classloader;

/**
 * 初始化顺序
 * 父类 静态成员 static块
 * 子类 静态成员 static块
 * 父类 普通成员 非static块
 * 父类构造函数
 * 子类 普通成员 非static块
 * 子类构造函数
 */
public class SubClass extends ParentClass {

    // 静态变量 
    public static String s_StaticField = "子类--静态变量";

    // 变量 
    public String s_Field = "子类--变量";

    // 静态初始化块 
    static {
        System.out.println(s_StaticField);
        System.out.println("子类--静态初始化块");
    }

    // 初始化块 
    {
        System.out.println(s_Field);
        System.out.println("子类--初始化块");
    }

    // 构造器 
    public SubClass() {
        System.out.println("子类--构造器");
        System.out.println("i=" + i + ",j=" + j);
    }

    // 程序入口 
    public static void main(String[] args) {
        new SubClass();
    }
}