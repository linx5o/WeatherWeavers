package view.weather;

import app.ImportFont;
import interface_adapter.Hourly.HourlyController;
import interface_adapter.Hourly.HourlyState;
import interface_adapter.Hourly.HourlyViewModel;
import view.RoundedPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HourlyView extends RoundedPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "hourly";

    private final JLabel hourlyLabel = new JLabel(HourlyViewModel.HOURLY_LABEL);
    private final JLabel temp1Label = new JLabel();
    private final JLabel temp2Label = new JLabel();
    private final JLabel temp3Label = new JLabel();
    private final JLabel temp4Label = new JLabel();
    private final JLabel temp5Label = new JLabel();
    private final JLabel time1Label = new JLabel();
    private final JLabel time2Label = new JLabel();
    private final JLabel time3Label = new JLabel();
    private final JLabel time4Label = new JLabel();
    private final JLabel time5Label = new JLabel();

    private final HourlyController controller;
    private final HourlyViewModel hourlyViewModel;

    public HourlyView(HourlyController controller, HourlyViewModel hourlyViewModel) {
        super(40);
        this.controller = controller;
        this.hourlyViewModel = hourlyViewModel;

        this.setPreferredSize(new Dimension(420, 180));

        this.controller.execute();
        hourlyViewModel.addPropertyChangeListener(this);

        HourlyState state = hourlyViewModel.getState();

        this.temp1Label.setText(state.getTemp1());
        this.temp2Label.setText(state.getTemp2());
        this.temp3Label.setText(state.getTemp3());
        this.temp4Label.setText(state.getTemp4());
        this.temp5Label.setText(state.getTemp5());
        this.time1Label.setText(state.getTime1());
        this.time2Label.setText(state.getTime2());
        this.time3Label.setText(state.getTime3());
        this.time4Label.setText(state.getTime4());
        this.time5Label.setText(state.getTime5());

//        this.temp1Label.setText("20°");
//        this.temp2Label.setText("21°");
//        this.temp3Label.setText("22°");
//        this.temp4Label.setText("23°");
//        this.temp5Label.setText("24°");
//        this.time1Label.setText("12:00");
//        this.time2Label.setText("13:00");
//        this.time3Label.setText("14:00");
//        this.time4Label.setText("15:00");
//        this.time5Label.setText("16:00");

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.decode("#222B3A"));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(20, 20, 0, 358);
        this.add(this.hourlyLabel, constraints);
        hourlyLabel.setFont(ImportFont.getFont("ExtraLight", 14));
        hourlyLabel.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(20, 0, 0, 0);

        JPanel tempPanel = new JPanel(new GridLayout(1, 5));
        tempPanel.setBackground(Color.decode("#222B3A"));
        tempPanel.setPreferredSize(new Dimension(420, 50));
        tempPanel.add(this.temp1Label);
        tempPanel.add(this.temp2Label);
        tempPanel.add(this.temp3Label);
        tempPanel.add(this.temp4Label);
        tempPanel.add(this.temp5Label);
        this.add(tempPanel, constraints);
        temp1Label.setFont(ImportFont.getFont("Medium", 24));
        temp1Label.setForeground(Color.decode("#FFFFFF"));
        temp2Label.setFont(ImportFont.getFont("Medium", 24));
        temp2Label.setForeground(Color.decode("#FFFFFF"));
        temp3Label.setFont(ImportFont.getFont("Medium", 24));
        temp3Label.setForeground(Color.decode("#FFFFFF"));
        temp4Label.setFont(ImportFont.getFont("Medium", 24));
        temp4Label.setForeground(Color.decode("#FFFFFF"));
        temp5Label.setFont(ImportFont.getFont("Medium", 24));
        temp5Label.setForeground(Color.decode("#FFFFFF"));
        temp1Label.setHorizontalAlignment(JLabel.CENTER);
        temp2Label.setHorizontalAlignment(JLabel.CENTER);
        temp3Label.setHorizontalAlignment(JLabel.CENTER);
        temp4Label.setHorizontalAlignment(JLabel.CENTER);
        temp5Label.setHorizontalAlignment(JLabel.CENTER);
        temp1Label.setPreferredSize(new Dimension(84, 50));
        temp2Label.setPreferredSize(new Dimension(84, 50));
        temp3Label.setPreferredSize(new Dimension(84, 50));
        temp4Label.setPreferredSize(new Dimension(84, 50));
        temp5Label.setPreferredSize(new Dimension(84, 50));

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(10, 0, 0, 0);

        JPanel timePanel = new JPanel(new GridLayout(1, 5));
        timePanel.setOpaque(false);
        timePanel.setPreferredSize(new Dimension(420, 50));
        timePanel.add(this.time1Label);
        timePanel.add(this.time2Label);
        timePanel.add(this.time3Label);
        timePanel.add(this.time4Label);
        timePanel.add(this.time5Label);
        this.add(timePanel, constraints);
        time1Label.setFont(ImportFont.getFont("ExtraLight", 14));
        time1Label.setForeground(Color.decode("#FFFFFF"));
        time2Label.setFont(ImportFont.getFont("ExtraLight", 14));
        time2Label.setForeground(Color.decode("#FFFFFF"));
        time3Label.setFont(ImportFont.getFont("ExtraLight", 14));
        time3Label.setForeground(Color.decode("#FFFFFF"));
        time4Label.setFont(ImportFont.getFont("ExtraLight", 14));
        time4Label.setForeground(Color.decode("#FFFFFF"));
        time5Label.setFont(ImportFont.getFont("ExtraLight", 14));
        time5Label.setForeground(Color.decode("#FFFFFF"));
        time1Label.setHorizontalAlignment(JLabel.CENTER);
        time2Label.setHorizontalAlignment(JLabel.CENTER);
        time3Label.setHorizontalAlignment(JLabel.CENTER);
        time4Label.setHorizontalAlignment(JLabel.CENTER);
        time5Label.setHorizontalAlignment(JLabel.CENTER);
        time1Label.setPreferredSize(new Dimension(84, 50));
        time2Label.setPreferredSize(new Dimension(84, 50));
        time3Label.setPreferredSize(new Dimension(84, 50));
        time4Label.setPreferredSize(new Dimension(84, 50));
        time5Label.setPreferredSize(new Dimension(84, 50));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: implement
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // TODO: implement
    }
}
