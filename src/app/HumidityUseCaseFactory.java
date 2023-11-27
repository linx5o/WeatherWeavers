package app;

import interface_adapter.GetWeather.HumidityController;
import interface_adapter.GetWeather.HumidityPresenter;
import interface_adapter.GetWeather.HumidityViewModel;
import use_case.get_weather.GetSettingsDataAccessInterface;
import use_case.humidity.HumidityDataAccessInterface;
import use_case.humidity.HumidityInputBoundary;
import use_case.humidity.HumidityInteractor;
import use_case.humidity.HumidityOutputBoundary;
import view.weather.HumidityView;

public class HumidityUseCaseFactory {
    private HumidityUseCaseFactory() {}

    public static HumidityView create(HumidityViewModel humidityViewModel, HumidityDataAccessInterface humidityDataAccessObject, GetSettingsDataAccessInterface getSettingsDataAccessObject) {
        try {
            HumidityController humidityController = createHumidityUseCase(humidityViewModel, humidityDataAccessObject, getSettingsDataAccessObject);
            return new HumidityView(humidityController, humidityViewModel);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    private static HumidityController createHumidityUseCase(HumidityViewModel humidityViewModel, HumidityDataAccessInterface humidityDataAccessObject, GetSettingsDataAccessInterface getSettingsDataAccessObject) {
        HumidityOutputBoundary humidityOutputBoundary = new HumidityPresenter(humidityViewModel);

        HumidityInputBoundary humidityInteractor = new HumidityInteractor(humidityDataAccessObject, humidityOutputBoundary, getSettingsDataAccessObject);

        return new HumidityController(humidityInteractor);
    }
}
