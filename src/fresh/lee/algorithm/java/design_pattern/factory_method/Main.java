package fresh.lee.algorithm.java.design_pattern.factory_method;

import fresh.lee.algorithm.java.design_pattern.factory_method.factory.AddFactory;
import fresh.lee.algorithm.java.design_pattern.factory_method.factory.DivFactory;
import fresh.lee.algorithm.java.design_pattern.factory_method.factory.MulFactory;
import fresh.lee.algorithm.java.design_pattern.factory_method.factory.SubFactory;
import fresh.lee.algorithm.java.design_pattern.factory_method.operation.Div;
import fresh.lee.algorithm.java.design_pattern.factory_method.operation.IOperation;
import fresh.lee.algorithm.java.design_pattern.factory_method.operation.Mul;
import fresh.lee.algorithm.java.design_pattern.singleton.Singleton;

public class Main {

    public static void main(String[] args) {
        AddFactory singleton = new Singleton<AddFactory>() {
            @Override
            protected AddFactory create() {
                return new AddFactory();
            }
        }.get();

        double a = 12;
        double b = 6;

        IOperation op = singleton.createOperation();
        System.out.println(a + "+" + b + " = " + op.op(a, b));

        op = new SubFactory().createOperation();
        System.out.println(a + "-" + b + " = " + op.op(a, b));

        op = new MulFactory().createOperation();
        System.out.println(a + "*" + b + " = " + op.op(a, b));

        op = new DivFactory().createOperation();
        System.out.println(a + "/" + b + " = " + op.op(a, b));

        b = 0;
        op = new DivFactory().createOperation();
        System.out.println(a + "/" + b + " = " + op.op(a, b));
    }
}
