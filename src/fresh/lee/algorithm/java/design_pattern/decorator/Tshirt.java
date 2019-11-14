package fresh.lee.algorithm.java.design_pattern.decorator;

public class Tshirt extends Finery {

    @Override
    public void show() {
        System.out.print("大T恤 ");
        super.show();
    }
}
