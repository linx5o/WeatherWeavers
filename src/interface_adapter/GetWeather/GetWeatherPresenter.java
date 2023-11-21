package interface_adapter.GetWeather;

import use_case.get_weather.GetWeatherOutputBoundary;
import use_case.get_weather.GetWeatherOutputData;

import javax.swing.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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

        int sunrise = Integer.parseInt(getWeatherOutputData.getSunrise());
        int sunset = Integer.parseInt(getWeatherOutputData.getSunset());
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
        int formattedTime = Integer.parseInt(now.format(formatter));
        if (getWeatherOutputData.getDescriptions().equals("Sunny") || getWeatherOutputData.getDescriptions().equals("Clear")) {
            if (sunrise < formattedTime && formattedTime < sunset) {
                // Daytime
                state.setDescription("Sunny");
                state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/sunny.png"));
            } else {
                // Nighttime
                state.setDescription("Clear");
                state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/clear.png"));
            }
        } else if (getWeatherOutputData.getDescriptions().equals("Partly cloudy")) {
            state.setDescription("Partly cloudy");
            if (sunrise < formattedTime && formattedTime < sunset) {
                // Daytime
                state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/partly_cloudy.png"));
            } else {
                // Nighttime
                state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/partly_cloudy_night.png"));
            }
        } else if (getWeatherOutputData.getDescriptions().equals("Cloudy")) {
            state.setDescription("Cloudy");
            if (sunrise < formattedTime && formattedTime < sunset) {
                // Daytime
                state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/cloudy.png"));
            } else {
                // Nighttime
                state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/cloudy_night.png"));
            }
        } else if (getWeatherOutputData.getDescriptions().equals("Overcast")) {
            state.setDescription("Overcast");
            state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/overcast.png"));
        } else if (getWeatherOutputData.getDescriptions().equals("143")) {
            state.setDescription("Mist");
            state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/mist.png"));
        } else if (getWeatherOutputData.getDescriptions().equals("176")) {
            state.setDescription("Patchy rain possible");
            state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/patchy_rain.png"));
        } else if (getWeatherOutputData.getDescriptions().equals("179")) {
            state.setDescription("Patchy snow possible");
            state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/patchy_snow.png"));
        } else if (getWeatherOutputData.getDescriptions().equals("182")) {
            state.setDescription("Patchy sleet possible");
            state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/patchy_sleet.png"));
        } else if (getWeatherOutputData.getDescriptions().equals("185")) {
            state.setDescription("Patchy freezing drizzle possible");
            state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/patchy_freezing_drizzle.png"));
        } else if (getWeatherOutputData.getDescriptions().equals("200")) {
            state.setDescription("Thundery outbreaks possible");
            state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/thundery_outbreaks.png"));
        } else if (getWeatherOutputData.getDescriptions().equals("227")) {
            state.setDescription("Blowing snow");
            state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/blowing_snow.png"));
        } else if (getWeatherOutputData.getDescriptions().equals("230")) {
            state.setDescription("Blizzard");
            state.setTemperatureIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/blizzard.png"));

        }
    }

    @Override
    public void prepareFailView(String error) {
        // TODO
    }
}
