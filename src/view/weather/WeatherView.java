package view.weather;

import interface_adapter.WeatherViewModel;

import javax.swing.*;
import java.awt.*;

public class WeatherView extends JPanel {
    public final String viewName = "weather";

    private final WeatherViewModel weatherViewModel;

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public WeatherView(GetWeatherView getWeatherView, HourlyView hourlyView, HumidityView humidityView, OtherCitiesView otherCitiesView, ForecastView forecastView, WeatherViewModel weatherViewModel) {
        this.weatherViewModel = weatherViewModel;

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.decode("#0D131D"));
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        this.add(getWeatherView, c);

        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(20, 0, 0, 0);
        this.add(hourlyView, c);

        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(20, 440, 0, 0);
        this.add(humidityView, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        c.insets = new Insets(20, 0, 20, 0);
        this.add(forecastView, c);

        c.gridx = 2;
        c.gridy = 0;
        c.gridheight = 2;
        c.insets = new Insets(0, 20, 0, 20);
        this.add(otherCitiesView, c);
    }
}
