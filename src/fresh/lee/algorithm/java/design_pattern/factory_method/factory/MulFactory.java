package fresh.lee.algorithm.java.design_pattern.factory_method.factory;

import fresh.lee.algorithm.java.design_pattern.factory_method.operation.IOperation;
import fresh.lee.algorithm.java.design_pattern.factory_method.operation.Mul;
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
