package fresh.lee.algorithm.java.design_pattern.factory_1.factory;

import fresh.lee.algorithm.java.design_pattern.factory_1.operation.IOperation;

public interface IFactory {
    IOperation createOperation();
}
