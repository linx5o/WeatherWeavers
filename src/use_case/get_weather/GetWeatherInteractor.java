package use_case.get_weather;

import entity.Weather;

public class GetWeatherInteractor implements GetWeatherInputBoundary{

    final GetWeatherDataAccessInterface getWeatherDataAccessObject;
    final GetSettingsDataAccessInterface getSettingsDataAccessObject;
    final GetWeatherOutputBoundary getWeatherPresenter;
    final Boolean celicus;
    final String city;

    public GetWeatherInteractor(GetWeatherDataAccessInterface getWeatherDataAccessObject, GetSettingsDataAccessInterface getSettingsDataAccessObject, GetWeatherOutputBoundary getWeatherPresenter) {
        this.getWeatherDataAccessObject = getWeatherDataAccessObject;
        this.getSettingsDataAccessObject = getSettingsDataAccessObject;
        this.getWeatherPresenter = getWeatherPresenter;
        this.celicus = this.getSettingsDataAccessObject.getIfCelcius();
        this.city = this.getSettingsDataAccessObject.getPreferredCity();
    }

    @Override
    public void execute(GetWeatherInputData getWeatherInputData) {
        Weather weather = this.getWeatherDataAccessObject.getCityWeather(this.city, getWeatherInputData.getDate(), this.celicus);
        if (weather == null) {
            this.getWeatherPresenter.prepareFailView("Error");
        } else {
            this.getWeatherPresenter.prepareSuccessView(new GetWeatherOutputData()); // add parameters later
        }

    }

}
