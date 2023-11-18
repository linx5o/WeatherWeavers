package app;

import interface_adapter.GetWeather.HumidityController;
import interface_adapter.GetWeather.HumidityPresenter;
import interface_adapter.GetWeather.HumidityViewModel;
import use_case.humidity.HumidityDataAccessInterface;
import use_case.humidity.HumidityInputBoundary;
import use_case.humidity.HumidityInteractor;
import use_case.humidity.HumidityOutputBoundary;
import view.Weather.HumidityView;

public class HumidityUseCaseFactory {
    private HumidityUseCaseFactory() {}

    public static HumidityView create(HumidityViewModel humidityViewModel, HumidityDataAccessInterface humidityDataAccessObject) {
        try {
            HumidityController humidityController = createHumidityUseCase(humidityViewModel, humidityDataAccessObject);
            return new HumidityView(humidityController, humidityViewModel);
        } catch (Exception e) {
            // TODO - better error handling
        }

        return null;
    }

    private static HumidityController createHumidityUseCase(HumidityViewModel humidityViewModel, HumidityDataAccessInterface humidityDataAccessObject) {
        HumidityOutputBoundary humidityOutputBoundary = new HumidityPresenter(humidityViewModel);

        HumidityInputBoundary humidityInteractor = new HumidityInteractor(humidityDataAccessObject, humidityOutputBoundary);

        return new HumidityController(humidityInteractor);
    }
}
