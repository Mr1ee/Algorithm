package fresh.lee.algorithm.java.design_pattern.factory;

public interface IOperation<T extends Number> {
    T op(T a, T b);
}
