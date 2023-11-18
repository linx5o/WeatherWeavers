package view.Weather;

import interface_adapter.ForecastViewModel;
import interface_adapter.GetWeather.GetWeatherController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ForecastView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "forecast";

    private final ForecastController controller;
    private final ForecastViewModel forecastViewModel;

    public ForecastView(ForecastController controller, ForecastViewModel forecastViewModel) {
        this.controller = controller;
        this.forecastViewModel = forecastViewModel;
        forecastViewModel.addPropertyChangeListener(this);

        ForecastState state = forecastViewModel.getState();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
