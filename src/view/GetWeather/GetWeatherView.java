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

    public GetWeatherView(GetWeatherController controller, GetWeatherViewModel getWeatherViewModel) {

    }

}
