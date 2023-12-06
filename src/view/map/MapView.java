package view.map;

import interface_adapter.GetWeatherOnMap.GetWeatherOnMapController;
import interface_adapter.GetWeatherOnMap.GetWeatherOnMapViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

public class MapView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "map";

    JPanel mapPanel = new JPanel();

    private final GetWeatherOnMapController controller;
    private final GetWeatherOnMapViewModel viewModel;


    public MapView(GetWeatherOnMapController controller, GetWeatherOnMapViewModel viewModel) {
        this.controller = controller;
        this.viewModel = viewModel;

        controller.execute();
        this.viewModel.addPropertyChangeListener(this);

        this.add(mapPanel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        mapPanel = viewModel.getState().getMapPanel();
    }
}
