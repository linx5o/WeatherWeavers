package interface_adapter.GetWeather;

import use_case.get_weather.GetWeatherOutputBoundary;
import use_case.get_weather.GetWeatherOutputData;

import javax.swing.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
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

        Set likely = new HashSet();
        likely.add("AR:")

        int sunrise = Integer.parseInt(getWeatherOutputData.getSunrise());
        int sunset = Integer.parseInt(getWeatherOutputData.getSunset());
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
        int formattedTime = Integer.parseInt(now.format(formatter));

        if (getWeatherOutputData.getDescriptions().equals("::CL")) {
            if (formattedTime > sunrise && formattedTime < sunset) {
                state.setDescription("Sunny");
                state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/sunny.png"));
            } else {
                state.setDescription("Clear");
                state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/clear.png"));
            }
        } else if (getWeatherOutputData.getDescriptions().equals("::FW") || getWeatherOutputData.getDescriptions().equals("::SC")) {
            state.setDescription("Partly Cloudy");
            if (formattedTime > sunrise && formattedTime < sunset) {
                state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/partly_cloudy.png"));
            } else {
                state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/partly_cloudy_night.png"));
            }
        } else if (getWeatherOutputData.getDescriptions().equals("::BK")) {
            state.setDescription("Mostly Cloudy");
            if (formattedTime > sunrise && formattedTime < sunset) {
                state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/mostly_cloudy.png"));
            } else {
                state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/mostly_cloudy_night.png"));
            }
        } else if (getWeatherOutputData.getDescriptions().equals("::OV")) {
            state.setDescription("Cloudy");
            state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/cloudy.png"));
        } else if (getWeatherOutputData.getDescriptions())
    }

    @Override
    public void prepareFailView(String error) {
        // TODO
    }
}
