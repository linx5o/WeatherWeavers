package interface_adapter.GetWeatherOnMap;

import use_case.get_weather_on_map.GetWeatherOnMapInputBoundary;
import use_case.get_weather_on_map.GetWeatherOnMapInputData;

public class GetWeatherOnMapController {
    final GetWeatherOnMapInputBoundary getWeatherOnMapInteractor;

    public GetWeatherOnMapController(GetWeatherOnMapInputBoundary getWeatherOnMapInteractor) {
        this.getWeatherOnMapInteractor = getWeatherOnMapInteractor;
    }

    public void execute() {
        GetWeatherOnMapInputData getWeatherOnMapInputData = new GetWeatherOnMapInputData();
        getWeatherOnMapInteractor.execute(getWeatherOnMapInputData);
    }
}
