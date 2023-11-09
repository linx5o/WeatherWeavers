package use_case.weather;

public interface GetWeatherDataAccessInterface {
    Weather getCityWeather(String city);
}
