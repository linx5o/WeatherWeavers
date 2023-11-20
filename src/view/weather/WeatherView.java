package view.weather;

import javax.swing.*;
import java.awt.*;

public class WeatherView extends JPanel {
    public final String viewName = "weather";

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public WeatherView(GetWeatherView getWeatherView, HourlyView hourlyView, HumidityView humidityView, OtherCitiesView otherCitiesView, ForecastView forecastView) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        this.add(getWeatherView, c);

        c.gridx = 0;
        c.gridy = 1;
        this.add(hourlyView, c);

        c.gridx = 1;
        c.gridy = 1;
        this.add(humidityView, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        this.add(forecastView, c);

        c.gridx = 2;
        c.gridy = 0;
        c.gridheight = 2;
        this.add(otherCitiesView, c);
    }
}
