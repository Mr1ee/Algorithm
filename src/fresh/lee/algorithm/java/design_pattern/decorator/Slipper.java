package fresh.lee.algorithm.java.design_pattern.decorator;

public class Slipper extends Finery {
    @Override
    public void show() {
        System.out.print("拖鞋 ");
        super.show();
    }
}
