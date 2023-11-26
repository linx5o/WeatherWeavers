package use_case.get_weather_on_map;

import entity.Weather;

public interface GetWeatherOnMapDataAccessInterface {
    Weather getWeatherByName(String cityname, Boolean isCelsius);
}
