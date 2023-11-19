package use_case.forecast;

import entity.Location;
import entity.Weather;
import use_case.get_weather.GetSettingsDataAccessInterface;

import java.util.List;

public class ForecastInteractor implements ForecastInputBoundary {
    final ForecastDataAccessInterface forecastDataAccessObject;
    final ForecastOutputBoundary forecastPresenter;
    final GetSettingsDataAccessInterface getSettingsDataAccessObject;

    public ForecastInteractor(ForecastDataAccessInterface forecastDataAccessObject, GetSettingsDataAccessInterface getSettingsDataAccessObject,
                              ForecastOutputBoundary forecastPresenter) {
        this.forecastDataAccessObject = forecastDataAccessObject;
        this.forecastPresenter = forecastPresenter;
        this.getSettingsDataAccessObject = getSettingsDataAccessObject;
    }

    @Override
    public void execute(ForecastInputData forecastInputData) {
        String city = forecastInputData.getCity();
        int days = forecastInputData.getDays();
        boolean information = forecastInputData.isInformation();
        List<Weather> forcastList = forecastDataAccessObject.getForecast(city, days, getSettingsDataAccessObject.getSettings().getCelsius());
        if (information){
            ForecastOutputData forecastOutputData = new ForecastOutputData(days, forcastList, true);
            forecastPresenter.prepareInformationForecast(forecastOutputData);
        } else {
            ForecastOutputData forecastOutputData = new ForecastOutputData(days, forcastList, false);
            forecastPresenter.prepareForecast(forecastOutputData);
        }
    }
}
