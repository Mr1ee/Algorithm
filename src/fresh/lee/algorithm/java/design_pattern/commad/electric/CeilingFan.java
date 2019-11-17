package fresh.lee.algorithm.java.design_pattern.commad.electric;

/**
 * 吊扇
 */
public class CeilingFan implements Switch {
    @Override
    public void on() {
        System.out.println("CeilingFan on.");
    }

    @Override
    public void off() {
        System.out.println("CeilingFan off.");
    }

    public void setVolume(int volume) {
        System.out.println("set ceiling-fan volume : " + volume);
    }
}
