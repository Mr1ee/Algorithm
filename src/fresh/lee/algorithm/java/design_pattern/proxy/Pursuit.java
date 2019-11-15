package fresh.lee.algorithm.java.design_pattern.proxy;

public class Pursuit implements Action {

    private SchoolGirl girl;

    public Pursuit(SchoolGirl girl) {
        this.girl = girl;
    }

    @Override
    public void giveDolls() {
        System.out.println(girl + "， 送你洋娃娃");
    }

    @Override
    public void giveFlowers() {
        System.out.println(girl + "， 送你花");
    }

    @Override
    public void giveChocolate() {
        System.out.println(girl + "， 送你巧克力");
    }
}
