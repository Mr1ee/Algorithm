package fresh.lee.algorithm.java.design_pattern.factory_method.operation;

public class Mul implements IOperation {
    @Override
    public double op(double a, double b) {
        return a * b;
    }
}
