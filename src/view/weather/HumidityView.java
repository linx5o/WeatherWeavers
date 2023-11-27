package view.weather;

import app.ImportFont;
import interface_adapter.GetWeather.HumidityController;
import interface_adapter.GetWeather.HumidityState;
import interface_adapter.GetWeather.HumidityViewModel;
import view.RoundedPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HumidityView extends RoundedPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "humidity";

    private final JLabel humidityLabel = new JLabel();
    private final JLabel humidityValue = new JLabel();
    private final JLabel humidityDescription = new JLabel();

    private final HumidityController controller;
    private final HumidityViewModel humidityViewModel;

    public HumidityView(HumidityController controller, HumidityViewModel humidityViewModel) {
        super(40);
        this.controller = controller;
        this.humidityViewModel = humidityViewModel;

        this.setPreferredSize(new Dimension(180, 180));
        this.setBackground(Color.decode("#222B3A"));

        this.controller.execute();
        humidityViewModel.addPropertyChangeListener(this);

        HumidityState state = humidityViewModel.getState();

        this.humidityLabel.setText("Humidity");
        this.humidityValue.setText(state.getHumidity());
        this.humidityDescription.setText(state.getDescriptions());

//        this.humidityValue.setText("57%");
//        this.humidityDescription.setText("Dry");

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;

        this.setLayout(new GridBagLayout());

//        JPanel humidityPanel = new RoundedPanel(20);
//        humidityPanel.setPreferredSize(new Dimension(180, 180));
//        humidityPanel.setBackground(Color.decode("#222B3A"));

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(20, 20, 0, 102);
        this.add(this.humidityLabel, constraints);
        humidityLabel.setFont(ImportFont.getFont("ExtraLight", 14));
        humidityLabel.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(23, 20, 0, 0);
        this.add(this.humidityValue, constraints);
        humidityValue.setFont(ImportFont.getFont("Medium", 64));
        humidityValue.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(10, 20, 18, 0);
        this.add(this.humidityDescription, constraints);
        humidityDescription.setFont(ImportFont.getFont("Regular", 12));
        humidityDescription.setForeground(Color.decode("#FFFFFF"));
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
