package interface_adapter.Forecast;

import entity.Location;
import use_case.forecast.ForecastInputBoundary;
import use_case.forecast.ForecastInputData;

public class ForecastController {
    final ForecastInputBoundary forcastUseCaseInteractor;

    public ForecastController(ForecastInputBoundary forcastUseCaseInteractor) {
        this.forcastUseCaseInteractor = forcastUseCaseInteractor;
    }

    public void execute(Location location, int days, boolean information){
        ForecastInputData forecastInputData = new ForecastInputData(location, days, information);
        forcastUseCaseInteractor.execute(forecastInputData);
    }
}
