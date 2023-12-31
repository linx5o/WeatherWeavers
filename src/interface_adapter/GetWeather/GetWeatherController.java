package interface_adapter.GetWeather;

import use_case.get_weather.GetWeatherInputBoundary;
import use_case.get_weather.GetWeatherInputData;

import java.time.LocalTime;

public class GetWeatherController {
    final GetWeatherInputBoundary getWeatherInteractor;

    public GetWeatherController(GetWeatherInputBoundary getWeatherInteractor) {
        this.getWeatherInteractor = getWeatherInteractor;
    }

    public void execute(String city) {
        GetWeatherInputData getWeatherInputData = new GetWeatherInputData(city);
        getWeatherInteractor.execute(getWeatherInputData);
    }

    public void execute() {
        getWeatherInteractor.execute(LocalTime.now());
    }
}
