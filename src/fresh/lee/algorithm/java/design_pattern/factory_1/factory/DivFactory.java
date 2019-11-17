package fresh.lee.algorithm.java.design_pattern.factory_1.factory;

import fresh.lee.algorithm.java.design_pattern.factory_1.operation.Div;
import fresh.lee.algorithm.java.design_pattern.factory_1.operation.IOperation;
import fresh.lee.algorithm.java.design_pattern.singleton.Singleton;

public class DivFactory implements IFactory {
    @Override
    public IOperation createOperation() {
        return new Singleton<Div>() {
            @Override
            protected Div create() {
                return new Div();
            }
        }.get();
    }
}
