package view.Weather;

import interface_adapter.GetWeather.HumidityController;
import interface_adapter.GetWeather.HumidityState;
import interface_adapter.GetWeather.HumidityViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HumidityView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "humidity";

    private final JLabel humidityLabel = new JLabel();
    private final JLabel humidityDescription = new JLabel();

    private final HumidityController controller;
    private final HumidityViewModel humidityViewModel;

    public HumidityView(HumidityController controller, HumidityViewModel humidityViewModel) {
        this.controller = controller;
        this.humidityViewModel = humidityViewModel;
        humidityViewModel.addPropertyChangeListener(this);

        HumidityState state = humidityViewModel.getState();

        this.humidityLabel.setText(state.getHumidity());
        this.humidityDescription.setText(state.getDescriptions());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        HumidityState state = humidityViewModel.getState();

        this.humidityLabel.setText(state.getHumidity());
        this.humidityDescription.setText(state.getDescriptions());
    }
}
