package app;

import interface_adapter.Humidity.HumidityController;
import interface_adapter.Humidity.HumidityPresenter;
import interface_adapter.Humidity.HumidityViewModel;
import use_case.get_weather.GetSettingsDataAccessInterface;
import use_case.humidity.*;
import view.weather.HumidityView;

public class HumidityUseCaseFactory {
    private HumidityUseCaseFactory() {}

    public static HumidityView create(HumidityViewModel humidityViewModel, HumidityDataAccessInterface humidityDataAccessObject, HumiditySettingDataAccessInterface getSettingsDataAccessObject) {
        try {
            HumidityController humidityController = createHumidityUseCase(humidityViewModel, humidityDataAccessObject, getSettingsDataAccessObject);
            return new HumidityView(humidityController, humidityViewModel);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    private static HumidityController createHumidityUseCase(HumidityViewModel humidityViewModel, HumidityDataAccessInterface humidityDataAccessObject, HumiditySettingDataAccessInterface getSettingsDataAccessObject) {
        HumidityOutputBoundary humidityOutputBoundary = new HumidityPresenter(humidityViewModel);

        HumidityInputBoundary humidityInteractor = new HumidityInteractor(humidityDataAccessObject, humidityOutputBoundary, getSettingsDataAccessObject);

        return new HumidityController(humidityInteractor);
    }
}
