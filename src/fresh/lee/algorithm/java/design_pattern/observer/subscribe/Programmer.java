package fresh.lee.algorithm.java.design_pattern.observer.subscribe;

/**
 * 程序猿
 */
public class Programmer implements ISubscriber<WeatherData> {

    private String name;

    private String topic;

    public Programmer(String name, String area) {
        this.name = name;
        this.topic = area;
    }

    @Override
    public void update(WeatherData data) {
        System.out.println(name + "收到天气消息:");
        String weather;
        switch (data.getState()) {
            case WeatherData.SUNNY:
                weather = "晴天";
                break;
            case WeatherData.WINDY:
                weather = "刮大风";
                break;
            case WeatherData.CLOUDY:
                weather = "多云";
                break;
            case WeatherData.RAIN:
                weather = "下暴雨";
                break;
            default:
                weather = "出BUG了";
        }
        System.out.println("今天天气" + weather + ", 但是依然不妨碍我去上班！");
    }

    @Override
    public String topic() {
        return topic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return name;
    }
}
