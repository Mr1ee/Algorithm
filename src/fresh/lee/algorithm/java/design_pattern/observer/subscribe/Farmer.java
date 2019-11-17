package fresh.lee.algorithm.java.design_pattern.observer.subscribe;

/**
 * 农名伯伯
 */
public class Farmer implements ISubscriber<WeatherData> {
    private String topic;
    private String name;

    public Farmer(String name, String area) {
        this.name = name;
        this.topic = area;
    }

    @Override
    public void update(WeatherData data) {
        System.out.println(name + "收到天气消息:");
        switch (data.getState()) {
            case WeatherData.SUNNY:
            case WeatherData.WINDY:
            case WeatherData.CLOUDY:
                System.out.println("今天是个好天气，去农场");
                break;
            case WeatherData.RAIN:
                System.out.println("下雨了，今天休息");
                break;
            default:
                System.out.println("今天天气预报神马情况?");
        }
    }

    @Override
    public String topic() {
        return topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
