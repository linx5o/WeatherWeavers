package data_access;

import entity.Weather;
import use_case.get_weather.GetWeatherDataAccessInterface;

public class GetWeatherDataAccessObject implements GetWeatherDataAccessInterface {
    @Override
    public Weather getCityWeather(String city, String date, Boolean celsius) {
        return null;
    }
}
