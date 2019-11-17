package fresh.lee.algorithm.java.design_pattern.factory_1.operation;

public class Div implements IOperation {
    @Override
    public double op(double a, double b) {
        if (Math.abs(b) < 0.000001) {
            throw new IllegalArgumentException("被除数是0！");
        } else {
            return a / b;
        }
    }
}
