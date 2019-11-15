package fresh.lee.algorithm.java.design_pattern.factory_method.factory;

import fresh.lee.algorithm.java.design_pattern.factory_method.operation.IOperation;
import fresh.lee.algorithm.java.design_pattern.factory_method.operation.Sub;
import fresh.lee.algorithm.java.design_pattern.singleton.Singleton;

public class SubFactory implements IFactory {
    @Override
    public IOperation createOperation() {
        return new Singleton<Sub>() {
            @Override
            protected Sub create() {
                return new Sub();
            }
        }.get();
    }
}
