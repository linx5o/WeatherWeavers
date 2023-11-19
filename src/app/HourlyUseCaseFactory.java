package app;

import interface_adapter.GetWeather.HourlyViewModel;
import use_case.get_weather.GetSettingsDataAccessInterface;
import use_case.hourly.HourlyDataAccessInterface;
import use_case.hourly.HourlyInputBoundary;
import use_case.hourly.HourlyInteractor;
import use_case.hourly.HourlyOutputBoundary;
import view.Weather.HourlyView;

public class HourlyUseCaseFactory {
    private HourlyUseCaseFactory() {}

    public static HourlyView create(HourlyViewModel hourlyViewModel, HourlyDataAccessInterface hourlyDataAccessObject, GetSettingsDataAccessInterface getSettingsDataAccessObject) {
        try {
            HourlyController hourlyController = createHourlyUseCase(hourlyViewModel, hourlyDataAccessObject, getSettingsDataAccessObject);
            return new HourlyView(hourlyController, hourlyViewModel);
        } catch (Exception e) {
            // TODO - better error handling
        }

        return null;
    }

    private static HourlyController createHourlyUseCase(HourlyViewModel hourlyViewModel, HourlyDataAccessInterface hourlyDataAccessObject, GetSettingsDataAccessInterface getSettingsDataAccessObject) {
        HourlyOutputBoundary hourlyOutputBoundary = new HourlyPresenter(hourlyViewModel);

        HourlyInputBoundary hourlyInteractor = new HourlyInteractor(hourlyOutputBoundary, hourlyDataAccessObject, getSettingsDataAccessObject);

        return new HourlyController(hourlyInteractor);
    }
}
