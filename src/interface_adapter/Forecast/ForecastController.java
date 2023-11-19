package interface_adapter.Forecast;

import entity.Location;
import use_case.forecast.ForecastInputBoundary;
import use_case.forecast.ForecastInputData;

public class ForecastController {
    final ForecastInputBoundary forecastUseCaseInteractor;

    public ForecastController(ForecastInputBoundary forecastUseCaseInteractor) {
        this.forecastUseCaseInteractor = forecastUseCaseInteractor;
    }

    public void execute(String city, int days, boolean information){
        ForecastInputData forecastInputData = new ForecastInputData(city, days, information);
        forecastUseCaseInteractor.execute(forecastInputData);
    }
}
