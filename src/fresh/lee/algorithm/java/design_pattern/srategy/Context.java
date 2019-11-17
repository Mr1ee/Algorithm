package fresh.lee.algorithm.java.design_pattern.srategy;

import fresh.lee.algorithm.java.design_pattern.factory.IOperation;
import fresh.lee.algorithm.java.design_pattern.factory.OperationFactory;

public class Context implements IOperation<Integer> {

    private IOperation<Integer> mOperation;

    public Context(String op) {
        mOperation = OperationFactory.createOp(op);
    }

    @Override
    public Integer op(Integer a, Integer b) {
        return mOperation.op(a, b);
    }

    /**
     * OO原则：封装变化； 多用组合（复合），少用继承； 针对接口编程，不针对实现（细节）编程
     * <p>
     * 策略模式+简单工厂 客户端（main）只认识Context，不认识IOperation也不认识OperationFactory
     * 进一步封装了代码，以后增加逻辑的话只需要新增一个类继承IOperation，并且在OperationFactory增加一个case即可，
     * 完全不需要改动客户端代码
     * <p>
     * 策略模式定义了算法族，分别封装起来，让它们之间可以相互替换。
     * 此模式让算法变化独立于使用算法的客户端。
     */
    public static void main(String[] args) {
        IOperation<Integer> operation = new Context("+");
        System.out.println(operation.op(3, 4));
    }
}
