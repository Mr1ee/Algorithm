package fresh.lee.algorithm.java.inner_class;

public class AnotherClass {
    public static void main(String[] args) {
        OtterClass.StaticInnerClass staticInnerClass = new OtterClass.StaticInnerClass("static inner class ");
        System.out.println(staticInnerClass.idAppended());

        /**
         * 非静态内部类实例对象，必须先实例化外部类类对象!!!
         */
        OtterClass.NonStaticInnerClass innerClass = new OtterClass().new NonStaticInnerClass("nonstatic inner class ");
        System.out.println(innerClass.idAppended());
    }
}
