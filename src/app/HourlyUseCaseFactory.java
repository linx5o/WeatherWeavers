package app;

import interface_adapter.GetWeather.HourlyController;
import interface_adapter.GetWeather.HourlyPresenter;
import interface_adapter.GetWeather.HourlyViewModel;
import use_case.get_weather.GetSettingsDataAccessInterface;
import use_case.hourly.*;
import view.weather.HourlyView;

public class HourlyUseCaseFactory {
    private HourlyUseCaseFactory() {}

    public static HourlyView create(HourlyViewModel hourlyViewModel, HourlyDataAccessInterface hourlyDataAccessObject, HourlySettingsDataAccessInterface getSettingsDataAccessObject) {
        try {
            HourlyController hourlyController = createHourlyUseCase(hourlyViewModel, hourlyDataAccessObject, getSettingsDataAccessObject);
            return new HourlyView(hourlyController, hourlyViewModel);
        } catch (Exception e) {
            // TODO - better error handling
        }

        return null;
    }

    private static HourlyController createHourlyUseCase(HourlyViewModel hourlyViewModel, HourlyDataAccessInterface hourlyDataAccessObject, HourlySettingsDataAccessInterface getSettingsDataAccessObject) {
        HourlyOutputBoundary hourlyOutputBoundary = new HourlyPresenter(hourlyViewModel);

        HourlyInputBoundary hourlyInteractor = new HourlyInteractor(hourlyOutputBoundary, hourlyDataAccessObject, getSettingsDataAccessObject);

        return new HourlyController(hourlyInteractor);
    }
}
