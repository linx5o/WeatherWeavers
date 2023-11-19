package interface_adapter.Forecast;

import interface_adapter.ViewManagerModel;
import use_case.forecast.ForecastOutputBoundary;
import use_case.forecast.ForecastOutputData;

public class ForecastPresenter implements ForecastOutputBoundary {
    private final ForecastViewModel forcastViewModel;

    public ForecastPresenter(ForecastViewModel forecastViewModel) {
        this.forcastViewModel = forecastViewModel;
    }

    @Override
    public void prepareInformationForecast(ForecastOutputData forecast) {
        // TODO - implement
    }

    @Override
    public void prepareForecast(ForecastOutputData forecast) {
        // TODO - implement
    }
}
