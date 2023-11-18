package interface_adapter.Forecast;

import interface_adapter.ViewManagerModel;
import use_case.forecast.ForecastOutputBoundary;
import use_case.forecast.ForecastOutputData;

public class ForecastPresenter implements ForecastOutputBoundary {
    private final ForecastViewModel forcastViewModel;
    private ViewManagerModel viewManagerModel;

    public ForecastPresenter(ForecastViewModel forecastViewModel) {
        this.forcastViewModel = forecastViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareInformationForecast(ForecastOutputData forecast) {

    }

    @Override
    public void prepareForecast(ForecastOutputData forecast) {

    }
}
