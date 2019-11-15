package fresh.lee.algorithm.java.design_pattern.factory_method.factory;

import fresh.lee.algorithm.java.design_pattern.factory_method.operation.Add;
import fresh.lee.algorithm.java.design_pattern.factory_method.operation.IOperation;
import fresh.lee.algorithm.java.design_pattern.singleton.Singleton;

public class AddFactory implements IFactory {
    @Override
    public IOperation createOperation() {
        return new Singleton<Add>() {
            @Override
            protected Add create() {
                return new Add();
            }
        }.get();
    }
}
