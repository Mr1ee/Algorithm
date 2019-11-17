package fresh.lee.algorithm.java.design_pattern.commad.electric;

/**
 * 音响
 */
public class Stereo implements Switch {

    private int volume;
    private int radio;

    @Override
    public void on() {
        System.out.println("打开音响");
    }

    @Override
    public void off() {
        System.out.println("关闭音响");
    }

    public void setCD() {

    }

    public void setDVD() {

    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("设置音响音量:" + volume);
    }
}
