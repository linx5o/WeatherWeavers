package interface_adapter.Forecast;

import interface_adapter.ViewManagerModel;
import use_case.forecast.ForecastOutputBoundary;
import use_case.forecast.ForecastOutputData;

public class ForecastPresenter implements ForecastOutputBoundary {
    private final ForecastViewModel forcastViewModel;
    private ViewManagerModel viewManagerModel;

    public ForecastPresenter(ViewManagerModel viewManagerModel,
                             ForecastViewModel forcastViewModel) {
        this.forcastViewModel = forcastViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareInformationForcast(ForecastOutputData forcast) {

    }

    @Override
    public void prepareForcast(ForecastOutputData forcast) {

    }
}
