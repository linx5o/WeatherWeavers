package view.Weather;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HumidityView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "humidity";

    private final HumidityController controller;
    private final HumidityViewModel humidityViewModel;

    public HumidityView(HumidityController controller, HumidityViewModel humidityViewModel) {
        this.controller = controller;
        this.humidityViewModel = humidityViewModel;
        humidityViewModel.addPropertyChangeListener(this);

        HumidityState state = humidityViewModel.getState();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
