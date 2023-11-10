package use_case.weather;

import entity.Weather;

public interface weatherDataAccessInterface {
    Weather getCityWeather(String city);
}
