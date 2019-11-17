package fresh.lee.algorithm.java.design_pattern.observer.subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherStation implements IPublisher<WeatherData> {

    private WeatherData data;
    private String area;

    private Map<String, List<ISubscriber<WeatherData>>> subscriberMap = new HashMap<>();

    @Override
    public void addSubscriber(ISubscriber<WeatherData> subscriber) {
        String topic = subscriber.topic();
        System.out.println(subscriber + "订阅了" + subscriber.topic() + "的天气");
        if (subscriberMap.containsKey(topic)) {
            subscriberMap.get(subscriber.topic()).add(subscriber);
        } else {
            List<ISubscriber<WeatherData>> newList = new ArrayList<>();
            newList.add(subscriber);
            subscriberMap.put(subscriber.topic(), newList);
        }
    }

    @Override
    public void removeSubscriber(ISubscriber<WeatherData> subscriber) {
        System.out.println(subscriber + "取消订阅了" + subscriber.topic() + "的天气");
        if (subscriberMap.containsKey(subscriber.topic())) {
            subscriberMap.get(subscriber.topic()).remove(subscriber);
        }
    }

    @Override
    public void notifyDataChanged() {
        if (subscriberMap != null && !subscriberMap.isEmpty()) {
            if (subscriberMap.containsKey(area)) {
                for (ISubscriber<WeatherData> subscriber : subscriberMap.get(area)) {
                    subscriber.update(data);
                }
            }
        }
    }

    public WeatherData getData() {
        return data;
    }

    public void setData(WeatherData data, String area) {
        this.data = data;
        this.area = area;
        System.out.println();
        System.out.println(area + "气象站发布最新天气预报：");
        System.out.println("天气：" + data.getState() + "，温度：" + data.getTemperature());
        notifyDataChanged();
    }
}
