package use_case.get_weather;

import java.time.LocalTime;

public interface GetWeatherInputBoundary {
    void execute(GetWeatherInputData getWeatherInputData);

    void execute(LocalTime localTime);
}
