package view.GetWeather;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import interface_adapter.GetWeather.GetWeatherController;
import interface_adapter.GetWeather.GetWeatherViewModel;

public class GetWeatherView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "get weather";

    private final JLabel city = new JLabel();
    private final JLabel date = new JLabel();
    private final JLabel temperatureIcon = new JLabel();
    private final JLabel temperature = new JLabel();
    private final JLabel temperatureLabel = new JLabel();
    private final JLabel highTemperature = new JLabel();
    private final JLabel lowTemperature = new JLabel();
    private final JLabel wind = new JLabel();
    private final JLabel rain = new JLabel();
    private final JLabel sunrise = new JLabel();
    private final JLabel sunset = new JLabel();

    private final GetWeatherController controller;
    private final GetWeatherViewModel getWeatherViewModel;


    public GetWeatherView(GetWeatherController controller, GetWeatherViewModel getWeatherViewModel) {
        this.controller = controller;
        this.getWeatherViewModel = getWeatherViewModel;
        getWeatherViewModel.addPropertyChangeListener(this);

        GetweatherState state = getWeatherViewModel.getState();

        this.city.setText(state.getCity());
        this.date.setText(state.getDate());
        this.temperatureIcon.setText(state.getTemperatureIcon());
        this.temperature.setText(state.getTemperature());
        this.temperatureLabel.setText(state.getTemperatureLabel());
        this.highTemperature.setText(state.getHighTemperature());
        this.lowTemperature.setText(state.getLowTemperature());
        this.wind.setText(state.getWind());
        this.rain.setText(state.getRain());
        this.sunrise.setText(state.getSunrise());
        this.sunset.setText(state.getSunset());


    }

}
