package fresh.lee.algorithm.java.design_pattern.decorator;

public class Suit extends Finery {

    @Override
    public void show() {
        System.out.print("正装 ");
        super.show();
    }
}
