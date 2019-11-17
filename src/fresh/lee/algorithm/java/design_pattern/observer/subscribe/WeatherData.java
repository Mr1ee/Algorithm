package fresh.lee.algorithm.java.design_pattern.observer.subscribe;


public class WeatherData {

    public static final int SUNNY = 1;
    public static final int CLOUDY = SUNNY << 1;
    public static final int WINDY = SUNNY << 2;
    public static final int RAIN = SUNNY << 3;

    private float temperature;
    private int state;

    public WeatherData(int state, float temperature) {
        this.state = state;
        this.temperature = temperature;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
