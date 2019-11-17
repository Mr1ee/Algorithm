package fresh.lee.algorithm.java.design_pattern.observer.subscribe;

public class Main {

    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        Farmer farmer = new Farmer("农民伯伯1", "朝阳区");
        Programmer programmer = new Programmer("程序猿", "朝阳区");
        Programmer programmer1 = new Programmer("程序猿1", "海淀区");
        station.addSubscriber(farmer);
        station.addSubscriber(programmer);
        station.addSubscriber(programmer1);

        station.setData(new WeatherData(WeatherData.SUNNY, 10.0f), "朝阳区");
        station.setData(new WeatherData(WeatherData.WINDY, 10.0f), "朝阳区");
        station.setData(new WeatherData(WeatherData.RAIN, 10.0f), "朝阳区");

        station.removeSubscriber(farmer);
        farmer.setTopic("海淀区");
        station.addSubscriber(farmer);

        station.setData(new WeatherData(WeatherData.CLOUDY, 10.0f), "朝阳区");
        station.setData(new WeatherData(10, 10.0f), "朝阳区");
        station.setData(new WeatherData(WeatherData.RAIN, 10.0f), "海淀区");
        station.setData(new WeatherData(WeatherData.RAIN, 10.0f), "通州区");

    }
}
