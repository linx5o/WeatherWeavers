package interface_adapter.GetWeather;

import use_case.get_weather.GetWeatherOutputBoundary;
import use_case.get_weather.GetWeatherOutputData;

import javax.swing.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        if (getWeatherOutputData.getDescriptions().equals("sunny")) {
            state.setDescription("Sunny");
            state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/sunny.png"));
        } else if (getWeatherOutputData.getDescriptions().equals("clear")) {
            state.setDescription("Clear");
            state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/clear.png"));
        } else {
            state.setDescription("Unknown");
            state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/unknown.png"));
        }

        state.setTemperature(getWeatherOutputData.getCurrentTemp() + "°");
        state.setHigh(getWeatherOutputData.getHighTemp() + "°");
        state.setLow(getWeatherOutputData.getLowTemp() + "°");
        state.setWind(getWeatherOutputData.getWindSpeed() + " KM/H");
        state.setRain(getWeatherOutputData.getRainPercent() + "%");
        state.setSunrise(getWeatherOutputData.getSunrise());
        state.setSunset(getWeatherOutputData.getSunset());
    }

    @Override
    public void prepareFailView(String error) {
        // TODO
    }
}
