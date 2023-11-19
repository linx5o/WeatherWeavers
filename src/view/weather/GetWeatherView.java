package view.Weather;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalTime;

import app.ImportFont;
import interface_adapter.GetWeather.GetWeatherController;
import interface_adapter.GetWeather.GetWeatherState;
import interface_adapter.GetWeather.GetWeatherViewModel;

public class GetWeatherView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "get weather";

    private final JLabel city = new JLabel();
    private final JLabel date = new JLabel();
    private final JLabel temperatureIcon = new JLabel();
    private final JLabel temperature = new JLabel();
    private final JLabel temperatureLabel = new JLabel();
    private final JLabel high = new JLabel();
    private final JLabel low = new JLabel();
    private final JLabel wind = new JLabel();
    private final JLabel rain = new JLabel();
    private final JLabel sunrise = new JLabel();
    private final JLabel sunset = new JLabel();

    private final GetWeatherController controller;
    private final GetWeatherViewModel getWeatherViewModel;


    public GetWeatherView(GetWeatherController controller, GetWeatherViewModel getWeatherViewModel) {
        this.controller = controller;
        this.getWeatherViewModel = getWeatherViewModel;

        controller.execute(LocalTime.now().toString());
        getWeatherViewModel.addPropertyChangeListener(this);

        GetWeatherState state = getWeatherViewModel.getState();

        this.city.setText(state.getCity());
        this.date.setText(state.getDate());
        this.temperatureIcon.setIcon(state.getTemperatureIcon());
        this.temperature.setText(state.getTemperature());
        this.temperatureLabel.setText(state.getDescription());
        this.high.setText(state.getHigh());
        this.low.setText(state.getLow());
        this.wind.setText(state.getWind());
        this.rain.setText(state.getRain());
        this.sunrise.setText(state.getSunrise());
        this.sunset.setText(state.getSunset());

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.decode("0D131D"));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.insets = new Insets(20, 20, 0, 0);
        this.add(city, constraints);
        city.setFont(ImportFont.getFont("Medium", 32));
        city.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.insets = new Insets(0, 20, 0, 0);
        this.add(date, constraints);
        date.setFont(ImportFont.getFont("ExtraLight", 14));
        date.setForeground(Color.decode("#FFFFFF"));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // TODO
    }
}
