package fresh.lee.algorithm.java.design_pattern.factory_1.factory;

import fresh.lee.algorithm.java.design_pattern.factory_1.operation.IOperation;
import fresh.lee.algorithm.java.design_pattern.factory_1.operation.Sub;
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
