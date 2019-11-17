package fresh.lee.algorithm.java.design_pattern.commad.electric;

public class Light implements Switch {

    private String where;

    public Light(String where) {
        this.where = where;
    }

    @Override
    public void on() {
        System.out.println(where + " Light on!");
    }

    @Override
    public void off() {
        System.out.println(where + "Light off!");
    }
}
