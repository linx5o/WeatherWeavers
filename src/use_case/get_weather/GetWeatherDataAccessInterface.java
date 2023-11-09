package use_case.get_weather;

import entity.Weather;

public interface GetWeatherDataAccessInterface {
    Weather getCityWeather(String city, String date);
}
