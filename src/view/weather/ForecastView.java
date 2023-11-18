package view.Weather;

import interface_adapter.Forcast.ForcastController;
import interface_adapter.Forcast.ForcastState;
import interface_adapter.Forcast.ForcastViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ForecastView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "forecast";

    private final ForcastController controller;
    private final ForcastViewModel forecastViewModel;

    public ForecastView(ForcastController controller, ForcastViewModel forecastViewModel) {
        this.controller = controller;
        this.forecastViewModel = forecastViewModel;
        forecastViewModel.addPropertyChangeListener(this);

        ForcastState state = forecastViewModel.getState();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
