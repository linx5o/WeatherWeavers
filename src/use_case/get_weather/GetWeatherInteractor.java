package use_case.get_weather;

import entity.Weather;

import java.time.LocalTime;

public class GetWeatherInteractor implements GetWeatherInputBoundary{

    final GetWeatherDataAccessInterface getWeatherDataAccessObject;
    final GetSettingsDataAccessInterface getSettingsDataAccessObject;
    final GetWeatherOutputBoundary getWeatherPresenter;

    public GetWeatherInteractor(GetWeatherDataAccessInterface getWeatherDataAccessObject, GetSettingsDataAccessInterface getSettingsDataAccessObject, GetWeatherOutputBoundary getWeatherPresenter) {
        this.getWeatherDataAccessObject = getWeatherDataAccessObject;
        this.getSettingsDataAccessObject = getSettingsDataAccessObject;
        this.getWeatherPresenter = getWeatherPresenter;
    }

    @Override
    public void execute(GetWeatherInputData getWeatherInputData) {
        Weather weather = this.getWeatherDataAccessObject.getCityWeather(getWeatherInputData.getCity(), getWeatherInputData.getTime(), getSettingsDataAccessObject.getSettings().getCelsius());
        if (weather == null) {
            this.getWeatherPresenter.prepareFailView("Error");
        } else {
            this.getWeatherPresenter.prepareSuccessView(new GetWeatherOutputData(weather));
        }

    }

    @Override
    public void execute(LocalTime localTime) {
        Weather weather = this.getWeatherDataAccessObject.getCityWeather(getSettingsDataAccessObject.getSettings().getDefaultCity(), localTime.toString(), getSettingsDataAccessObject.getSettings().getCelsius());
        if (weather == null) {
            this.getWeatherPresenter.prepareFailView("Error");
        } else {
            this.getWeatherPresenter.prepareSuccessView(new GetWeatherOutputData(weather));
        }
    }
}
