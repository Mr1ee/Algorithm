package fresh.lee.algorithm.java.design_pattern.proxy;

/**
 * 代理认是两者，gg认识mm，但是mm只认识代理，不认识gg
 */
public class Proxy implements Action {

    private Pursuit gg;

    public Proxy(SchoolGirl girl) {
        this.gg = new Pursuit(girl);
    }

    @Override
    public void giveDolls() {
        gg.giveDolls();
    }

    @Override
    public void giveFlowers() {
        gg.giveFlowers();
    }

    @Override
    public void giveChocolate() {
        gg.giveChocolate();
    }
}
