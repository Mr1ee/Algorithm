package fresh.lee.algorithm.java.design_pattern.factory_method.factory;

import fresh.lee.algorithm.java.design_pattern.factory_method.operation.Div;
import fresh.lee.algorithm.java.design_pattern.factory_method.operation.IOperation;
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
