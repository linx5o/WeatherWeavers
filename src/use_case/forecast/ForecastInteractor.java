package use_case.forecast;

import entity.Location;
import entity.Weather;
import data_access.GetSettingsDataAccessObject;

import java.util.List;

public class ForecastInteractor implements ForecastInputBoundary {
    final ForecastDataAccessInterface forecastDataAccessObject;
    final ForecastOutputBoundary forecastPresenter;
    final ForecastSettingsDataAccessInterface forecastSettingsDataAccessObject;

    public ForecastInteractor(ForecastDataAccessInterface forecastDataAccessObject, ForecastSettingsDataAccessInterface forecastSettingsDataAccessObject,
                              ForecastOutputBoundary forecastPresenter) {
        this.forecastDataAccessObject = forecastDataAccessObject;
        this.forecastPresenter = forecastPresenter;
        this.forecastSettingsDataAccessObject = forecastSettingsDataAccessObject;
    }

    @Override
    public void execute(ForecastInputData forecastInputData) {
        String city = forecastInputData.getCity();
        int days = forecastInputData.getDays();
        boolean information = forecastInputData.isInformation();
        getForecast(days, information, city);
    }

    @Override
    public void execute(int days, boolean information) {
        String city = forecastSettingsDataAccessObject.getSettings().getDefaultCity();
        getForecast(days, information, city);
    }

    private void getForecast(int days, boolean information, String city) {
        List<Weather> forcastList = forecastDataAccessObject.getForecast(city, days, forecastSettingsDataAccessObject.getSettings().getCelsius());
        if (forcastList == null) {
            forecastPresenter.prepareFailView("Error: Could not get forecast");
            return;
        }
        if (information) {
            ForecastOutputData forecastOutputData = new ForecastOutputData(days, forcastList, true);
            forecastPresenter.prepareInformationForecast(forecastOutputData);
        } else {
            ForecastOutputData forecastOutputData = new ForecastOutputData(days, forcastList, false);
            forecastPresenter.prepareForecast(forecastOutputData);
        }
    }
}
