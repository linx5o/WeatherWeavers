package interface_adapter.Forecast;

import entity.Location;
import use_case.forecast.ForecastInputBoundary;
import use_case.forecast.ForecastInputData;

public class ForecastController {
    final ForecastInputBoundary forecastUseCaseInteractor;

    public ForecastController(ForecastInputBoundary forecastUseCaseInteractor) {
        this.forecastUseCaseInteractor = forecastUseCaseInteractor;
    }

    public void execute(int days, boolean information){
        forecastUseCaseInteractor.execute(days, information);
    }
}
