package view.weather;

import interface_adapter.GetWeatherOnMap.GetWeatherOnMapController;
import interface_adapter.GetWeatherOnMap.GetWeatherOnMapViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MapView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Map View";
    private final JLabel map = new JLabel();

    private final GetWeatherOnMapController controller;
    private final GetWeatherOnMapViewModel humidityViewModel;

    public MapView(GetWeatherOnMapController controller, GetWeatherOnMapViewModel humidityViewModel) {
        this.controller = controller;
        this.humidityViewModel = humidityViewModel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
