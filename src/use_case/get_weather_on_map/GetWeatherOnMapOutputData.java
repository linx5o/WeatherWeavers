package use_case.get_weather_on_map;

import entity.Weather;

public class GetWeatherOnMapOutputData {
    private final Weather weather;

    public GetWeatherOnMapOutputData(Weather weather) {
        this.weather = weather;
    }

    public Weather getWeather() {
        return weather;
    }
}
