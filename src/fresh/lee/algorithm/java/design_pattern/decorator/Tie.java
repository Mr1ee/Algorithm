package fresh.lee.algorithm.java.design_pattern.decorator;

public class Tie extends Finery {

    @Override
    public void show() {
        System.out.print("领带 ");
        super.show();
    }
}
