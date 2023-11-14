package use_case.get_weather;

import entity.Weather;

public interface GetWeatherInputBoundary {
    void execute(GetWeatherInputData getWeatherInputData);
}
