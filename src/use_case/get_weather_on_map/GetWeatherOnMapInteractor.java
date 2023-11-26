package use_case.get_weather_on_map;

import entity.Weather;
import use_case.get_weather.GetSettingsDataAccessInterface;

public class GetWeatherOnMapInteractor implements GetWeatherOnMapInputBoundary{
    final GetWeatherOnMapDataAccessInterface getWeatherOnMapDataAccessObject;
    final GetWeatherOnMapOutputBoundary getWeatherOnMapPresenter;
    final GetSettingsDataAccessInterface getSettingsDataAccessObject;

    public GetWeatherOnMapInteractor(GetWeatherOnMapDataAccessInterface getWeatherOnMapDataAccessObject,
                                     GetWeatherOnMapOutputBoundary getWeatherOnMapPresenter,
                                     GetSettingsDataAccessInterface getSettingsDataAccessObject) {
        this.getWeatherOnMapDataAccessObject = getWeatherOnMapDataAccessObject;
        this.getWeatherOnMapPresenter = getWeatherOnMapPresenter;
        this.getSettingsDataAccessObject = getSettingsDataAccessObject;
    }

    @Override
    public void execute(GetWeatherOnMapInputData getWeatherOnMapInputData) {
        String city = getWeatherOnMapInputData.getCity();
        Weather weather = this.getWeatherOnMapDataAccessObject.getWeatherByName(city,
                this.getSettingsDataAccessObject.getSettings().getCelsius());
        GetWeatherOnMapOutputData getWeatherOnMapOutputData = new GetWeatherOnMapOutputData(weather);
        this.getWeatherOnMapPresenter.prepareWeatherPage(getWeatherOnMapOutputData);
    }
}
