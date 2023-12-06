package app;

import interface_adapter.Forecast.ForecastController;

import interface_adapter.Forecast.ForecastPresenter;

import interface_adapter.Forecast.ForecastViewModel;

import use_case.forecast.*;

import use_case.get_weather.GetSettingsDataAccessInterface;

import view.weather.ForecastView;

public class ForecastUseCaseFactory {
    private ForecastUseCaseFactory() {}

    public static ForecastView create(ForecastViewModel forecastViewModel, ForecastDataAccessInterface forecastDataAccessObject, ForecastSettingsDataAccessInterface getSettingsDataAccessObject) {
        try {
            ForecastController forecastController = createForecastUseCase(forecastViewModel, forecastDataAccessObject, getSettingsDataAccessObject);
            return new ForecastView(forecastController, forecastViewModel);
        } catch (Exception e) {
            // TODO - better error handling
        }

        return null;
    }

    private static ForecastController createForecastUseCase(ForecastViewModel forecastViewModel, ForecastDataAccessInterface forecastDataAccessObject, ForecastSettingsDataAccessInterface getSettingsDataAccessObject) {
        ForecastOutputBoundary forecastOutputBoundary = new ForecastPresenter(forecastViewModel);

        ForecastInputBoundary forecastInteractor = new ForecastInteractor(forecastDataAccessObject, getSettingsDataAccessObject, forecastOutputBoundary);

        return new ForecastController(forecastInteractor);
    }
}
