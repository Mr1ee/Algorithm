package fresh.lee.algorithm.java.design_pattern.factory_1.factory;

import fresh.lee.algorithm.java.design_pattern.factory_1.operation.IOperation;
import fresh.lee.algorithm.java.design_pattern.factory_1.operation.Mul;
import fresh.lee.algorithm.java.design_pattern.singleton.Singleton;

public class MulFactory implements IFactory {
    @Override
    public IOperation createOperation() {
        return new Singleton<Mul>() {
            @Override
            protected Mul create() {
                return new Mul();
            }
        }.get();
    }
}
