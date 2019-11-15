package fresh.lee.algorithm.java.design_pattern.factory_method.factory;

import fresh.lee.algorithm.java.design_pattern.factory_method.operation.IOperation;

public interface IFactory {
    IOperation createOperation();
}
