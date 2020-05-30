package fresh.lee.algorithm.java.classloader;

public class StaticDispatch {

    static abstract class Human {
        abstract public void sayHello();
    }

    static class Man extends Human {
        @Override
        public void sayHello() {
            System.out.println("man say Hello!");
        }
    }

    static class Woman extends Human {
        @Override
        public void sayHello() {
            System.out.println("woman say Hello!");
        }
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

        man.sayHello();
        woman.sayHello();
        // 输出
        //man say Hello!
        //woman say Hello!
    }
}
