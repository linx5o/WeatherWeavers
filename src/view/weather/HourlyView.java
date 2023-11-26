package view.weather;

import interface_adapter.GetWeather.HourlyController;
import interface_adapter.GetWeather.HourlyState;
import interface_adapter.GetWeather.HourlyViewModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HourlyView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "hourly";

    private final HourlyController controller;
    private final HourlyViewModel hourlyViewModel;

    public HourlyView(HourlyController controller, HourlyViewModel hourlyViewModel) {
        this.controller = controller;
        this.hourlyViewModel = hourlyViewModel;
        hourlyViewModel.addPropertyChangeListener(this);

        HourlyState state = hourlyViewModel.getState();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
