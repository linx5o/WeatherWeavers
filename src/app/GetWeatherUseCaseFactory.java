package app;

import interface_adapter.GetWeather.*;
import interface_adapter.ViewManagerModel;
import use_case.get_weather.*;
import view.Weather.GetWeatherView;

import javax.swing.*;
import java.io.IOException;

public class GetWeatherUseCaseFactory {
    private GetWeatherUseCaseFactory() {}

    public static GetWeatherView create(GetWeatherViewModel getWeatherViewModel, GetWeatherDataAccessInterface getWeatherDataAccessObject, GetSettingsDataAccessInterface getSettingsDataAccessObject) {
        try {
            GetWeatherController getWeatherController = createGetWeatherUseCase(getWeatherViewModel, getWeatherDataAccessObject, getSettingsDataAccessObject);
            return new GetWeatherView(getWeatherController, getWeatherViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open settings file");
            // TODO - better error handling
        }

        return null;
    }

    private static GetWeatherController createGetWeatherUseCase(GetWeatherViewModel getWeatherViewModel, GetWeatherDataAccessInterface getWeatherDataAccessObject, GetSettingsDataAccessInterface getSettingsDataAccessObject) throws IOException {
        GetWeatherOutputBoundary getWeatherOutputBoundary = new GetWeatherPresenter(getWeatherViewModel);

        GetWeatherInputBoundary getWeatherInteractor = new GetWeatherInteractor(getWeatherDataAccessObject, getSettingsDataAccessObject, getWeatherOutputBoundary);

        return new GetWeatherController(getWeatherInteractor);
    }
}
