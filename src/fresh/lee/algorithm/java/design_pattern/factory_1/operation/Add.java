package fresh.lee.algorithm.java.design_pattern.factory_1.operation;

public class Add implements IOperation {

    @Override
    public double op(double a, double b) {
        return a + b;
    }
}
