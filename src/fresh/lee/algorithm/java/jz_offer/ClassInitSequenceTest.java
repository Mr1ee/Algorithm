package fresh.lee.algorithm.java.jz_offer;

import java.util.ArrayList;
import java.util.List;

public class ClassInitSequenceTest {

    private static final int CONST_INT = 596;

    public static final String CONST_STR = "hoo~";

    private static List<String> list;

    static {
        System.out.println("static code block");
        list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("hi!");
    }

    public static void sMethod() {
        System.out.println("static method");
//        list.forEach(System.out::println);
    }

    public static void sMethod1() {
        System.out.println("static method");
        list.forEach(System.out::println);
    }

    public void method() {
        System.out.println("normal method");
    }

    public static void main(String[] args) {
        //静态方法测试
//        ClassInitSequence.sMethod1();


        //常量方法测试
//        ClassInitSequence test = new ClassInitSequence();
//        test.method();


        //静态属性（String 类型，并且已经在方法区中存在的变量）
//        ClassTest2 test2 = new ClassTest2();
        String str = ClassTest2.CONST_STR;
        System.out.println(ClassInitSequenceTest.CONST_STR);

        //静态属性（Int 类型，并且已经在方法区中存在的变量）
//        System.out.println(ClassInitSequenceTest.CONST_INT);

    }
}
