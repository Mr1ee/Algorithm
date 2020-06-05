package fresh.lee.algorithm.java.classloader;

public class Student {
    private Student() {
        throw new IllegalArgumentException("can not create.");
    }

    public String name;

    public static class Sub extends Student{

        public Sub(){

        }
    }
}