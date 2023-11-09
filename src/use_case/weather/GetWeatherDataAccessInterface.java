package use_case.weather;

import entity.Weather;

public interface GetWeatherDataAccessInterface {
    Weather getCityWeather(String city, String date);
}
