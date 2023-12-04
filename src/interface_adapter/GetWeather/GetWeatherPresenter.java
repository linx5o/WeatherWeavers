package interface_adapter.GetWeather;

import use_case.get_weather.GetWeatherOutputBoundary;
import use_case.get_weather.GetWeatherOutputData;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
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
        String city = getWeatherOutputData.getCity();
        int commaIndex = city.indexOf(",");
        if (commaIndex != -1) {
            city = city.substring(0, commaIndex);
        }
        city = city.substring(0, 1).toUpperCase() + city.substring(1);
        state.setCity(city);
        state.setDate(getWeatherOutputData.getWeekDay() + ", " + LocalDate.parse(getWeatherOutputData.getDate()).getDayOfMonth() + " " + LocalDate.parse(getWeatherOutputData.getDate()).getMonth());

        String description;
        String icon;
        String[] parts = getWeatherOutputData.getDescriptions().split(";");

        description = parts[0];
        icon = parts[1];

        try {
            state.setDescription(description);
            state.setTemperatureIcon(new ImageIcon("src/interface_adapter/icons/" + icon));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Could not open icon file");
        }

        state.setTemperature(getWeatherOutputData.getCurrentTemp() + "°");
        state.setHigh(getWeatherOutputData.getHighTemp() + "°");
        state.setLow(getWeatherOutputData.getLowTemp() + "°");
        state.setWind(getWeatherOutputData.getWindSpeed() + " KM/H");
        state.setRain(getWeatherOutputData.getRainPercent() + "%");
        if (getWeatherOutputData.getTimeFormat()) {
            state.setSunrise(LocalTime.parse(getWeatherOutputData.getSunrise()).format(DateTimeFormatter.ofPattern("HH:mm")));
            state.setSunset(LocalTime.parse(getWeatherOutputData.getSunset()).format(DateTimeFormatter.ofPattern("HH:mm")));
        } else {
            state.setSunrise(LocalTime.parse(getWeatherOutputData.getSunrise()).format(DateTimeFormatter.ofPattern("hh:mm a")));
            state.setSunset(LocalTime.parse(getWeatherOutputData.getSunset()).format(DateTimeFormatter.ofPattern("hh:mm a")));
        }
    }

    @Override
    public void prepareFailView(String error) {
        // TODO baby baby baby ohhhh my baby baby baby ohhhhhh my

    }
}
