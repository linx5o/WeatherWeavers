package use_case.forecast;

import entity.Location;
import entity.Weather;

import java.util.List;

public class ForecastInteractor implements ForecastInputBoundary {
    final ForecastDataAccessInterface forecastDataAccessObject;
    final ForecastOutputBoundary forecastPresenter;

    public ForecastInteractor(ForecastDataAccessInterface forecastDataAccessObject,
                              ForecastOutputBoundary forecastPresenter) {
        this.forecastDataAccessObject = forecastDataAccessObject;
        this.forecastPresenter = forecastPresenter;
    }

    @Override
    public void execute(ForecastInputData forecastInputData) {
        Location location = forecastInputData.getLocation();
        int days = forecastInputData.getDays();
        boolean information = forecastInputData.isInformation();
        List<Weather> forcastList = forecastDataAccessObject.getForecast(location, days);
        if (information){
            ForecastOutputData forecastOutputData = new ForecastOutputData(days, forcastList, true);
            forecastPresenter.prepareInformationForecast(forecastOutputData);
        } else {
            ForecastOutputData forecastOutputData = new ForecastOutputData(days, forcastList, false);
            forecastPresenter.prepareForecast(forecastOutputData);
        }
    }
}
