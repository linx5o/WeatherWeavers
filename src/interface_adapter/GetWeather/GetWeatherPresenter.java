package interface_adapter.GetWeather;

import use_case.get_weather.GetWeatherOutputBoundary;
import use_case.get_weather.GetWeatherOutputData;

import javax.swing.*;

public class GetWeatherPresenter implements GetWeatherOutputBoundary {
    private final GetWeatherViewModel getWeatherViewModel;

    public GetWeatherPresenter(GetWeatherViewModel getWeatherViewModel) {
        this.getWeatherViewModel = getWeatherViewModel;
    }

    @Override
    public void prepareSuccessView(GetWeatherOutputData getWeatherOutputData) {
        GetWeatherState state = getWeatherViewModel.getState();
        state.setCity(getWeatherOutputData.getCity());
        state.setDate(getWeatherOutputData.getWeekDay() + ", " + getWeatherOutputData.getDate());
        if (getWeatherOutputData.getDescriptions().equals("113")) {

            if ()

            state.setDescription("Sunny");
            state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/sunny.png"));
        }
    }

    @Override
    public void prepareFailView(String error) {
        // TODO
    }
}
