package view.Weather;

import interface_adapter.GetWeather.OtherCitiesState;
import interface_adapter.GetWeather.OtherCitiesViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OtherCitiesView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "other cities";

    private final OtherCitiesController controller;
    private final OtherCitiesViewModel otherCitiesViewModel;

    public OtherCitiesView(OtherCitiesController controller, OtherCitiesViewModel otherCitiesViewModel) {
        this.controller = controller;
        this.otherCitiesViewModel = otherCitiesViewModel;
        otherCitiesViewModel.addPropertyChangeListener(this);

        OtherCitiesState state = otherCitiesViewModel.getState();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
