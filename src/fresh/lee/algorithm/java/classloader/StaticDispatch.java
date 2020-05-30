package fresh.lee.algorithm.java.classloader;

public class StaticDispatch {

    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human guy) {
        System.out.println("Hello , guy!");
    }

    public void sayHello(Man man) {
        System.out.println("Hello , gentleman!");
    }

    public void sayHello(Woman woman) {
        System.out.println("Hello , lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);
        // 输出
        //Hello , guy!
        //Hello , guy!

        sr.sayHello((Man) man);
        sr.sayHello((Woman) woman);
        // 输出
        //Hello , gentleman!
        //Hello , lady!
    }

}
