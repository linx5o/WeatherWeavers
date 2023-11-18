package app;


import use_case.forecast.ForecastDataAccessInterface;
import use_case.get_weather.GetSettingsDataAccessInterface;
import view.Weather.ForecastView;

public class ForecastUseCaseFactory {
    private ForecastUseCaseFactory() {}

    public static ForecastView create(ForecastViewModel forecastViewModel, ForecastDataAccessInterface forecastDataAccessObject, GetSettingsDataAccessInterface getSettingsDataAccessObject) {
        try {
            ForecastController forecastController = createForecastUseCase(forecastViewModel, forecastDataAccessObject, getSettingsDataAccessObject);
            return new ForecastView(forecastController, forecastViewModel);
        } catch (Exception e) {
            // TODO - better error handling
        }

        return null;
    }

    private static ForecastController createForecastUseCase(ForecastViewModel forecastViewModel, ForecastDataAccessInterface forecastDataAccessObject, GetSettingsDataAccessInterface getSettingsDataAccessObject) {
        ForecastOutputBoundary forecastOutputBoundary = new ForecastPresenter(forecastViewModel);

        ForecastInputBoundary forecastInteractor = new ForecastInteractor(forecastDataAccessObject, getSettingsDataAccessObject, forecastOutputBoundary);

        return new ForecastController(forecastInteractor);
    }
}
