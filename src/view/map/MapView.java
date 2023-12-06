package view.map;

import interface_adapter.GetWeatherOnMap.GetWeatherOnMapController;
import interface_adapter.GetWeatherOnMap.GetWeatherOnMapViewModel;
import view.RoundedPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

public class MapView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "map";

    JPanel mapPanel = new RoundedPanel(40);

    private final GetWeatherOnMapController controller;
    private final GetWeatherOnMapViewModel viewModel;


    public MapView(GetWeatherOnMapController controller, GetWeatherOnMapViewModel viewModel) {
        this.controller = controller;
        this.viewModel = viewModel;

        this.viewModel.addPropertyChangeListener(this);
        controller.execute();

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.decode("#0D131D"));

        this.add(mapPanel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        viewModel.removePropertyChangeListener(this);
        controller.execute();
        viewModel.addPropertyChangeListener(this);
        this.remove(mapPanel);
        mapPanel = new RoundedPanel(40);
        mapPanel = viewModel.getState().getMapPanel();
        this.add(mapPanel);
    }
}
