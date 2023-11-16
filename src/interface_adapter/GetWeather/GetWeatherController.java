package interface_adapter.GetWeather;

import use_case.get_weather.GetWeatherInputBoundary;
import use_case.get_weather.GetWeatherInputData;

public class GetWeatherController {
    final GetWeatherInputBoundary getWeatherInteractor;

    public GetWeatherController(GetWeatherInputBoundary getWeatherInteractor) {
        this.getWeatherInteractor = getWeatherInteractor;
    }

    public void execute(String city) {
        GetWeatherInputData getWeatherInputData = new GetWeatherInputData(city);
        getWeatherInteractor.execute(getWeatherInputData);
    }
}
