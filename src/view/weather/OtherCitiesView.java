package view.weather;

import app.ImportFont;
import interface_adapter.GetWeather.OtherCitiesController;
import interface_adapter.GetWeather.OtherCitiesState;
import interface_adapter.GetWeather.OtherCitiesViewModel;
import view.RoundedPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OtherCitiesView extends RoundedPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "other cities";

    private final JLabel otherCitiesLabel = new JLabel();
    private final JButton viewMapButton = new JButton();
    private final JLabel city1NameLabel = new JLabel();
    private final JLabel city1WeatherConditionLabel = new JLabel();
    private final JLabel city1TemperatureLabel = new JLabel();

    private final JLabel city2NameLabel = new JLabel();
    private final JLabel city2WeatherConditionLabel = new JLabel();
    private final JLabel city2TemperatureLabel = new JLabel();

    private final JLabel city3NameLabel = new JLabel();
    private final JLabel city3WeatherConditionLabel = new JLabel();
    private final JLabel city3TemperatureLabel = new JLabel();

    private final JLabel city4NameLabel = new JLabel();
    private final JLabel city4WeatherConditionLabel = new JLabel();
    private final JLabel city4TemperatureLabel = new JLabel();

    private final JLabel city5NameLabel = new JLabel();
    private final JLabel city5WeatherConditionLabel = new JLabel();
    private final JLabel city5TemperatureLabel = new JLabel();

    private final JLabel city6NameLabel = new JLabel();
    private final JLabel city6WeatherConditionLabel = new JLabel();
    private final JLabel city6TemperatureLabel = new JLabel();

    private final OtherCitiesController controller;
    private final OtherCitiesViewModel otherCitiesViewModel;

    public OtherCitiesView(OtherCitiesController controller, OtherCitiesViewModel otherCitiesViewModel) {
        super(40);
        this.controller = controller;
        this.otherCitiesViewModel = otherCitiesViewModel;

        this.setPreferredSize(new Dimension(260, 460));
        this.setBackground(Color.decode("#222B3A"));

        this.controller.execute();
        otherCitiesViewModel.addPropertyChangeListener(this);

        OtherCitiesState state = otherCitiesViewModel.getState();

        this.otherCitiesLabel.setText("Other Cities");
        this.viewMapButton.setText("View Map");

        this.city1NameLabel.setText(state.getOtherCitiesWeather().get(0).getCityName());
        this.city1WeatherConditionLabel.setText(state.getOtherCitiesWeather().get(0).getWeatherCondition());
        this.city1TemperatureLabel.setText(state.getOtherCitiesWeather().get(0).getTemperature());

        this.city2NameLabel.setText(state.getOtherCitiesWeather().get(1).getCityName());
        this.city2WeatherConditionLabel.setText(state.getOtherCitiesWeather().get(1).getWeatherCondition());
        this.city2TemperatureLabel.setText(state.getOtherCitiesWeather().get(1).getTemperature());

        this.city3NameLabel.setText(state.getOtherCitiesWeather().get(2).getCityName());
        this.city3WeatherConditionLabel.setText(state.getOtherCitiesWeather().get(2).getWeatherCondition());
        this.city3TemperatureLabel.setText(state.getOtherCitiesWeather().get(2).getTemperature());

        this.city4NameLabel.setText(state.getOtherCitiesWeather().get(3).getCityName());
        this.city4WeatherConditionLabel.setText(state.getOtherCitiesWeather().get(3).getWeatherCondition());
        this.city4TemperatureLabel.setText(state.getOtherCitiesWeather().get(3).getTemperature());

        this.city5NameLabel.setText(state.getOtherCitiesWeather().get(4).getCityName());
        this.city5WeatherConditionLabel.setText(state.getOtherCitiesWeather().get(4).getWeatherCondition());
        this.city5TemperatureLabel.setText(state.getOtherCitiesWeather().get(4).getTemperature());

        this.city6NameLabel.setText(state.getOtherCitiesWeather().get(5).getCityName());
        this.city6WeatherConditionLabel.setText(state.getOtherCitiesWeather().get(5).getWeatherCondition());
        this.city6TemperatureLabel.setText(state.getOtherCitiesWeather().get(5).getTemperature());

//        this.city1NameLabel.setText("City 1");
//        this.city1WeatherConditionLabel.setText("Sunny");
//        this.city1TemperatureLabel.setText("77°");
//
//        this.city2NameLabel.setText("City 2");
//        this.city2WeatherConditionLabel.setText("Sunny");
//        this.city2TemperatureLabel.setText("77°");

        GridBagConstraints constraints = new GridBagConstraints();

        this.setLayout(new GridBagLayout());

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(15, 30, 0, 85);
        this.add(this.otherCitiesLabel, constraints);
        this.otherCitiesLabel.setFont(ImportFont.getFont("Medium", 12));
        this.otherCitiesLabel.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(15, 0, 0, 20);
        this.add(this.viewMapButton, constraints);
        this.viewMapButton.setFont(ImportFont.getFont("Medium", 10));
        this.viewMapButton.setForeground(Color.decode("#D9D9D9"));
        this.viewMapButton.setOpaque(false);
        this.viewMapButton.setContentAreaFilled(false);
        this.viewMapButton.setBorderPainted(false);
        this.viewMapButton.setPreferredSize(new Dimension(60, 20));
        this.viewMapButton.setAlignmentX(Component.RIGHT_ALIGNMENT);

        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.gridy = 1;
        constraints.insets = new Insets(10, 0, 0, 0);
        constraints.anchor = GridBagConstraints.CENTER;

        JPanel city1Info = new JPanel();
        city1Info.setLayout(new GridBagLayout());
        city1Info.setOpaque(false);
//        city1Info.setBorder(BorderFactory.createEmptyBorder(0, 10, 8, 0));
        GridBagConstraints city1InfoConstraints = new GridBagConstraints();
        city1InfoConstraints.anchor = GridBagConstraints.WEST;
        city1InfoConstraints.gridx = 0;
        city1InfoConstraints.gridy = 0;
        city1InfoConstraints.insets = new Insets(7, 10, 2, 0);
        city1Info.add(this.city1NameLabel, city1InfoConstraints);
        city1InfoConstraints.gridx = 0;
        city1InfoConstraints.gridy = 1;
        city1InfoConstraints.insets = new Insets(0, 10, 10, 0);
        city1Info.add(this.city1WeatherConditionLabel, city1InfoConstraints);

        RoundedPanel city1 = new RoundedPanel(20);
        GroupLayout layout = new GroupLayout(city1);
        city1.setLayout(layout);
        layout.setAutoCreateGaps(true);
//        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(city1Info, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(this.city1TemperatureLabel)
        );

        // Align vertically
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(city1Info)
                        .addComponent(this.city1TemperatureLabel)
        );
        this.city1NameLabel.setFont(ImportFont.getFont("Medium", 20));
        this.city1NameLabel.setForeground(Color.decode("#FFFFFF"));
        this.city1NameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
//        this.city1NameLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
//        this.city1NameLabel.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        this.city1WeatherConditionLabel.setFont(ImportFont.getFont("Light", 14));
        this.city1WeatherConditionLabel.setForeground(Color.decode("#FFFFFF"));
//        this.city1WeatherConditionLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 8, 0));
//        this.city1WeatherConditionLabel.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        this.city1WeatherConditionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.city1TemperatureLabel.setFont(ImportFont.getFont("Medium", 32));
        this.city1TemperatureLabel.setForeground(Color.decode("#FFFFFF"));
        this.city1TemperatureLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        this.city1TemperatureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.city1TemperatureLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 11, 10));
//        this.city1TemperatureLabel.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
//
        city1.setBackground(Color.decode("#2A3540"));
        city1.setMinimumSize(new Dimension(240, 60));
        this.add(city1, constraints);

        constraints.gridy = 2;

        JPanel city2Info = new JPanel();
        city2Info.setLayout(new GridBagLayout());
        city2Info.setOpaque(false);
//        city2Info.setBorder(BorderFactory.createEmptyBorder(0, 10, 8, 0));
        GridBagConstraints city2InfoConstraints = new GridBagConstraints();
        city2InfoConstraints.anchor = GridBagConstraints.WEST;
        city2InfoConstraints.gridx = 0;
        city2InfoConstraints.gridy = 0;
        city2InfoConstraints.insets = new Insets(7, 10, 2, 0);
        city2Info.add(this.city2NameLabel, city2InfoConstraints);
        city2InfoConstraints.gridx = 0;
        city2InfoConstraints.gridy = 1;
        city2InfoConstraints.insets = new Insets(0, 10, 10, 0);
        city2Info.add(this.city2WeatherConditionLabel, city2InfoConstraints);

        RoundedPanel city2 = new RoundedPanel(20);
        GroupLayout layout2 = new GroupLayout(city2);
        city2.setLayout(layout2);
        layout2.setAutoCreateGaps(true);

        layout2.setHorizontalGroup(
                layout2.createSequentialGroup()
                        .addComponent(city2Info, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(this.city2TemperatureLabel)
        );

        layout2.setVerticalGroup(
                layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(city2Info)
                        .addComponent(this.city2TemperatureLabel)
        );
        this.city2NameLabel.setFont(ImportFont.getFont("Medium", 20));
        this.city2NameLabel.setForeground(Color.decode("#FFFFFF"));
        this.city2NameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
//        this.city2NameLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
//        this.city2NameLabel.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        this.city2WeatherConditionLabel.setFont(ImportFont.getFont("Light", 14));
        this.city2WeatherConditionLabel.setForeground(Color.decode("#FFFFFF"));
//        this.city2WeatherConditionLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 8, 0));
//        this.city2WeatherConditionLabel.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        this.city2WeatherConditionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.city2TemperatureLabel.setFont(ImportFont.getFont("Medium", 32));
        this.city2TemperatureLabel.setForeground(Color.decode("#FFFFFF"));
        this.city2TemperatureLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        this.city2TemperatureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.city2TemperatureLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 11, 10));
//        this.city2TemperatureLabel.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));

        city2.setBackground(Color.decode("#2A3540"));
        city2.setMinimumSize(new Dimension(240, 60));
        this.add(city2, constraints);

        constraints.gridy = 3;

        JPanel city3Info = new JPanel();
        city3Info.setLayout(new GridBagLayout());
        city3Info.setOpaque(false);
//        city3Info.setBorder(BorderFactory.createEmptyBorder(0, 10, 8, 0));

        GridBagConstraints city3InfoConstraints = new GridBagConstraints();
        city3InfoConstraints.anchor = GridBagConstraints.WEST;
        city3InfoConstraints.gridx = 0;
        city3InfoConstraints.gridy = 0;
        city3InfoConstraints.insets = new Insets(7, 10, 2, 0);
        city3Info.add(this.city3NameLabel, city3InfoConstraints);
        city3InfoConstraints.gridx = 0;
        city3InfoConstraints.gridy = 1;
        city3InfoConstraints.insets = new Insets(0, 10, 10, 0);
        city3Info.add(this.city3WeatherConditionLabel, city3InfoConstraints);

        RoundedPanel city3 = new RoundedPanel(20);
        GroupLayout layout3 = new GroupLayout(city3);
        city3.setLayout(layout3);
        layout3.setAutoCreateGaps(true);

        layout3.setHorizontalGroup(
                layout3.createSequentialGroup()
                        .addComponent(city3Info, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(this.city3TemperatureLabel)
        );

        layout3.setVerticalGroup(
                layout3.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(city3Info)
                        .addComponent(this.city3TemperatureLabel)
        );
        this.city3NameLabel.setFont(ImportFont.getFont("Medium", 20));
        this.city3NameLabel.setForeground(Color.decode("#FFFFFF"));
        this.city3NameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
//        this.city3NameLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
//        this.city3NameLabel.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        this.city3WeatherConditionLabel.setFont(ImportFont.getFont("Light", 14));
        this.city3WeatherConditionLabel.setForeground(Color.decode("#FFFFFF"));
//        this.city3WeatherConditionLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 8, 0));
//        this.city3WeatherConditionLabel.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        this.city3WeatherConditionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.city3TemperatureLabel.setFont(ImportFont.getFont("Medium", 32));
        this.city3TemperatureLabel.setForeground(Color.decode("#FFFFFF"));
        this.city3TemperatureLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        this.city3TemperatureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.city3TemperatureLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 11, 10));
//        this.city3TemperatureLabel.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));

        city3.setBackground(Color.decode("#2A3540"));
        city3.setMinimumSize(new Dimension(240, 60));
        this.add(city3, constraints);

        constraints.gridy = 4;

        JPanel city4Info = new JPanel();
        city4Info.setLayout(new GridBagLayout());
        city4Info.setOpaque(false);

        GridBagConstraints city4InfoConstraints = new GridBagConstraints();
        city4InfoConstraints.anchor = GridBagConstraints.WEST;
        city4InfoConstraints.gridx = 0;
        city4InfoConstraints.gridy = 0;
        city4InfoConstraints.insets = new Insets(7, 10, 2, 0);
        city4Info.add(this.city4NameLabel, city4InfoConstraints);
        city4InfoConstraints.gridx = 0;
        city4InfoConstraints.gridy = 1;
        city4InfoConstraints.insets = new Insets(0, 10, 10, 0);
        city4Info.add(this.city4WeatherConditionLabel, city4InfoConstraints);

        RoundedPanel city4 = new RoundedPanel(20);
        GroupLayout layout4 = new GroupLayout(city4);
        city4.setLayout(layout4);
        layout4.setAutoCreateGaps(true);

        layout4.setHorizontalGroup(
                layout4.createSequentialGroup()
                        .addComponent(city4Info, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(this.city4TemperatureLabel)
        );

        layout4.setVerticalGroup(
                layout4.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(city4Info)
                        .addComponent(this.city4TemperatureLabel)
        );

        this.city4NameLabel.setFont(ImportFont.getFont("Medium", 20));
        this.city4NameLabel.setForeground(Color.decode("#FFFFFF"));
        this.city4NameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
//            this.city4NameLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
//            this.city4NameLabel.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        this.city4WeatherConditionLabel.setFont(ImportFont.getFont("Light", 14));
        this.city4WeatherConditionLabel.setForeground(Color.decode("#FFFFFF"));
//            this.city4WeatherConditionLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 8, 0));
//            this.city4WeatherConditionLabel.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        this.city4WeatherConditionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.city4TemperatureLabel.setFont(ImportFont.getFont("Medium", 32));
        this.city4TemperatureLabel.setForeground(Color.decode("#FFFFFF"));
        this.city4TemperatureLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        this.city4TemperatureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.city4TemperatureLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 11, 10));
//            this.city4TemperatureLabel.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));

        city4.setBackground(Color.decode("#2A3540"));
        city4.setMinimumSize(new Dimension(240, 60));
        this.add(city4, constraints);

        constraints.gridy = 5;

        JPanel city5Info = new JPanel();
        city5Info.setLayout(new GridBagLayout());
        city5Info.setOpaque(false);

        GridBagConstraints city5InfoConstraints = new GridBagConstraints();
        city5InfoConstraints.anchor = GridBagConstraints.WEST;
        city5InfoConstraints.gridx = 0;
        city5InfoConstraints.gridy = 0;
        city5InfoConstraints.insets = new Insets(7, 10, 2, 0);
        city5Info.add(this.city5NameLabel, city5InfoConstraints);
        city5InfoConstraints.gridx = 0;
        city5InfoConstraints.gridy = 1;
        city5InfoConstraints.insets = new Insets(0, 10, 10, 0);
        city5Info.add(this.city5WeatherConditionLabel, city5InfoConstraints);

        RoundedPanel city5 = new RoundedPanel(20);
        GroupLayout layout5 = new GroupLayout(city5);
        city5.setLayout(layout5);
        layout5.setAutoCreateGaps(true);

        layout5.setHorizontalGroup(
                layout5.createSequentialGroup()
                        .addComponent(city5Info, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(this.city5TemperatureLabel)
        );

        layout5.setVerticalGroup(
                layout5.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(city5Info)
                        .addComponent(this.city5TemperatureLabel)
        );

        this.city5NameLabel.setFont(ImportFont.getFont("Medium", 20));
        this.city5NameLabel.setForeground(Color.decode("#FFFFFF"));
        this.city5NameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
//                this.city5NameLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
//                this.city5NameLabel.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        this.city5WeatherConditionLabel.setFont(ImportFont.getFont("Light", 14));
        this.city5WeatherConditionLabel.setForeground(Color.decode("#FFFFFF"));
//                this.city5WeatherConditionLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 8, 0));
//                this.city5WeatherConditionLabel.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        this.city5WeatherConditionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.city5TemperatureLabel.setFont(ImportFont.getFont("Medium", 32));
        this.city5TemperatureLabel.setForeground(Color.decode("#FFFFFF"));
        this.city5TemperatureLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        this.city5TemperatureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.city5TemperatureLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 11, 10));

        city5.setBackground(Color.decode("#2A3540"));
        city5.setMinimumSize(new Dimension(240, 60));
        this.add(city5, constraints);

        constraints.gridy = 6;

        JPanel city6Info = new JPanel();
        city6Info.setLayout(new GridBagLayout());
        city6Info.setOpaque(false);

        GridBagConstraints city6InfoConstraints = new GridBagConstraints();
        city6InfoConstraints.anchor = GridBagConstraints.WEST;
        city6InfoConstraints.gridx = 0;
        city6InfoConstraints.gridy = 0;
        city6InfoConstraints.insets = new Insets(7, 10, 2, 0);
        city6Info.add(this.city6NameLabel, city6InfoConstraints);
        city6InfoConstraints.gridx = 0;
        city6InfoConstraints.gridy = 1;
        city6InfoConstraints.insets = new Insets(0, 10, 10, 0);
        city6Info.add(this.city6WeatherConditionLabel, city6InfoConstraints);

        RoundedPanel city6 = new RoundedPanel(20);
        GroupLayout layout6 = new GroupLayout(city6);
        city6.setLayout(layout6);
        layout6.setAutoCreateGaps(true);

        layout6.setHorizontalGroup(
                layout6.createSequentialGroup()
                        .addComponent(city6Info, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(this.city6TemperatureLabel)
        );

        layout6.setVerticalGroup(
                layout6.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(city6Info)
                        .addComponent(this.city6TemperatureLabel)
        );

        this.city6NameLabel.setFont(ImportFont.getFont("Medium", 20));
        this.city6NameLabel.setForeground(Color.decode("#FFFFFF"));
        this.city6NameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
//                this.city6NameLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
//                this.city6NameLabel.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        this.city6WeatherConditionLabel.setFont(ImportFont.getFont("Light", 14));
        this.city6WeatherConditionLabel.setForeground(Color.decode("#FFFFFF"));
//                this.city6WeatherConditionLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 8, 0));
//                this.city6WeatherConditionLabel.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        this.city6WeatherConditionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.city6TemperatureLabel.setFont(ImportFont.getFont("Medium", 32));
        this.city6TemperatureLabel.setForeground(Color.decode("#FFFFFF"));
        this.city6TemperatureLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        this.city6TemperatureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.city6TemperatureLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 11, 10));

        city6.setBackground(Color.decode("#2A3540"));
        city6.setMinimumSize(new Dimension(240, 60));
        this.add(city6, constraints);

        constraints.gridy = 7;

        JPanel city1Filler = new JPanel();
        city1Filler.setOpaque(false);
        city1Filler.setMinimumSize(new Dimension(240, 60));
        city1Filler.setVisible(false);
        this.add(city1Filler, constraints);

        constraints.gridy = 8;

        JPanel city2Filler = new JPanel();
        city2Filler.setOpaque(false);
        city2Filler.setMinimumSize(new Dimension(240, 60));
        city2Filler.setVisible(false);
        this.add(city2Filler, constraints);

        constraints.gridy = 9;

        JPanel city3Filler = new JPanel();
        city3Filler.setOpaque(false);
        city3Filler.setMinimumSize(new Dimension(240, 60));
        city3Filler.setVisible(false);
        this.add(city3Filler, constraints);

        constraints.gridy = 10;

        JPanel city4Filler = new JPanel();
        city4Filler.setOpaque(false);
        city4Filler.setMinimumSize(new Dimension(240, 60));
        city4Filler.setVisible(false);
        this.add(city4Filler, constraints);

        constraints.gridy = 11;

        JPanel city5Filler = new JPanel();
        city5Filler.setOpaque(false);
        city5Filler.setMinimumSize(new Dimension(240, 60));
        city5Filler.setVisible(false);
        this.add(city5Filler, constraints);

        constraints.gridy = 12;

        JPanel city6Filler = new JPanel();
        city6Filler.setOpaque(false);
        city6Filler.setMinimumSize(new Dimension(240, 60));
        city6Filler.setVisible(false);
        this.add(city6Filler, constraints);

        if (city1NameLabel.getText().isEmpty()) {
            city1.setVisible(false);
            city1Filler.setVisible(true);
        }
        if (city2NameLabel.getText().isEmpty()) {
            city2.setVisible(false);
            city2Filler.setVisible(true);
        }
        if (city3NameLabel.getText().isEmpty()) {
            city3.setVisible(false);
            city3Filler.setVisible(true);
        }
        if (city4NameLabel.getText().isEmpty()) {
            city4.setVisible(false);
            city4Filler.setVisible(true);
        }
        if (city5NameLabel.getText().isEmpty()) {
            city5.setVisible(false);
            city5Filler.setVisible(true);
        }
        if (city6NameLabel.getText().isEmpty()) {
            city6.setVisible(false);
            city6Filler.setVisible(true);
        }

        constraints.gridy = 13;

        JPanel filler = new JPanel();
        filler.setOpaque(false);
        filler.setMinimumSize(new Dimension(240, 10));
        this.add(filler, constraints);


//        RoundedPanel city1 = new RoundedPanel(20);
//        city1.setLayout(new );
//        city1.setMinimumSize(new Dimension(240, 60));
//        city1.setBackground(Color.decode("#2A3540"));
//        c.gridx = 0;
//        c.gridy = 0;
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.insets = new Insets(10, 10, 0, 0);
//        city1.add(this.city1NameLabel, c);
//        this.city1NameLabel.setFont(ImportFont.getFont("Medium", 20));
//        this.city1NameLabel.setForeground(Color.decode("#FFFFFF"));
//        this.city1NameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
//        this.city1NameLabel.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
//
//        c.gridx = 0;
//        c.gridy = 1;
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.insets = new Insets(1, 10, 8, 0);
//        city1.add(this.city1WeatherConditionLabel, c);
//        this.city1WeatherConditionLabel.setFont(ImportFont.getFont("Light", 14));
//        this.city1WeatherConditionLabel.setForeground(Color.decode("#FFFFFF"));
//        this.city1WeatherConditionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
//
//        JPanel city1Filler = new JPanel();
//        city1Filler.setBackground(Color.decode("#2A3540"));
//        c.gridx = 1;
//        c.gridy = 0;
//        c.gridheight = 2;
//        c.fill = GridBagConstraints.HORIZONTAL;
//        city1.add(city1Filler, c);
//        city1Filler.setMaximumSize(new Dimension(240, 60));
//        city1Filler.setPreferredSize(new Dimension(200, 60));
//        city1Filler.setMinimumSize(new Dimension(2, 60));
//        city1Filler.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
////        city1Filler.add(new JLabel("AAAAAAAAAAAAAAAAAAAAAAA"));
//
//        c.gridx = 2;
//        c.gridy = 0;
//        c.gridheight = 2;
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.insets = new Insets(10, 0, 11, 10);
//        c.anchor = GridBagConstraints.EAST;
//        city1.add(this.city1TemperatureLabel, c);
//        this.city1TemperatureLabel.setFont(ImportFont.getFont("Medium", 32));
//        this.city1TemperatureLabel.setForeground(Color.decode("#FFFFFF"));
//
//        this.add(city1, constraints);
//        constraints.gridy = 2;
//
//        c.anchor = GridBagConstraints.WEST;
//        RoundedPanel city2 = new RoundedPanel(20);
//        city2.setLayout(new GridBagLayout());
//        city2.setPreferredSize(new Dimension(240, 60));
//        city2.setBackground(Color.decode("#2A3540"));
//        c.gridx = 0;
//        c.gridy = 0;
//        c.insets = new Insets(10, 10, 0, 0);
//        city2.add(this.city2NameLabel, c);
//        this.city2NameLabel.setFont(ImportFont.getFont("Medium", 20));
//        this.city2NameLabel.setForeground(Color.decode("#FFFFFF"));
//
//        c.gridx = 0;
//        c.gridy = 1;
//        c.insets = new Insets(1, 10, 8, 0);
//        city2.add(this.city2WeatherConditionLabel, c);
//        this.city2WeatherConditionLabel.setFont(ImportFont.getFont("Light", 14));
//        this.city2WeatherConditionLabel.setForeground(Color.decode("#FFFFFF"));
//
//        c.gridx = 1;
//        c.gridy = 0;
//        c.gridheight = 2;
//        c.insets = new Insets(10, 0, 11, 10);
//        c.anchor = GridBagConstraints.EAST;
//        city2.add(this.city2TemperatureLabel, c);
//        this.city2TemperatureLabel.setFont(ImportFont.getFont("Medium", 32));
//        this.city2TemperatureLabel.setForeground(Color.decode("#FFFFFF"));
//
//        this.add(city2, constraints);
//        constraints.gridy = 3;
//
//        c.anchor = GridBagConstraints.WEST;
//        RoundedPanel city3 = new RoundedPanel(20);
//        city3.setLayout(new GridBagLayout());
//        city3.setPreferredSize(new Dimension(240, 60));
//        city3.setBackground(Color.decode("#2A3540"));
//        c.gridx = 0;
//        c.gridy = 0;
//        c.insets = new Insets(10, 10, 0, 0);
//        city3.add(this.city3NameLabel, c);
//        this.city3NameLabel.setFont(ImportFont.getFont("Medium", 20));
//        this.city3NameLabel.setForeground(Color.decode("#FFFFFF"));
//
//        c.gridx = 0;
//        c.gridy = 1;
//        c.insets = new Insets(1, 10, 8, 0);
//        city3.add(this.city3WeatherConditionLabel, c);
//        this.city3WeatherConditionLabel.setFont(ImportFont.getFont("Light", 14));
//        this.city3WeatherConditionLabel.setForeground(Color.decode("#FFFFFF"));
//
//        c.gridx = 1;
//        c.gridy = 0;
//        c.gridheight = 2;
//        c.insets = new Insets(10, 0, 11, 10);
//        c.anchor = GridBagConstraints.EAST;
//        city3.add(this.city3TemperatureLabel, c);
//        this.city3TemperatureLabel.setFont(ImportFont.getFont("Medium", 32));
//        this.city3TemperatureLabel.setForeground(Color.decode("#FFFFFF"));
//
//        this.add(city3, constraints);
//        constraints.gridy = 4;
//
//        c.anchor = GridBagConstraints.WEST;
//        RoundedPanel city4 = new RoundedPanel(20);
//        city4.setLayout(new GridBagLayout());
//        city4.setPreferredSize(new Dimension(240, 60));
//        city4.setBackground(Color.decode("#2A3540"));
//        c.gridx = 0;
//        c.gridy = 0;
//        c.insets = new Insets(10, 10, 0, 0);
//        city4.add(this.city4NameLabel, c);
//        this.city4NameLabel.setFont(ImportFont.getFont("Medium", 20));
//        this.city4NameLabel.setForeground(Color.decode("#FFFFFF"));
//
//        c.gridx = 0;
//        c.gridy = 1;
//        c.insets = new Insets(1, 10, 8, 0);
//        city4.add(this.city4WeatherConditionLabel, c);
//        this.city4WeatherConditionLabel.setFont(ImportFont.getFont("Light", 14));
//        this.city4WeatherConditionLabel.setForeground(Color.decode("#FFFFFF"));
//
//        c.gridx = 1;
//        c.gridy = 0;
//        c.gridheight = 2;
//        c.insets = new Insets(10, 0, 11, 10);
//        c.anchor = GridBagConstraints.EAST;
//        city4.add(this.city4TemperatureLabel, c);
//        this.city4TemperatureLabel.setFont(ImportFont.getFont("Medium", 32));
//        this.city4TemperatureLabel.setForeground(Color.decode("#FFFFFF"));
//
//        this.add(city4, constraints);
//        constraints.gridy = 5;
//
//        c.anchor = GridBagConstraints.WEST;
//        RoundedPanel city5 = new RoundedPanel(20);
//        city5.setLayout(new GridBagLayout());
//        city5.setPreferredSize(new Dimension(240, 60));
//        city5.setBackground(Color.decode("#2A3540"));
//        c.gridx = 0;
//        c.gridy = 0;
//        c.insets = new Insets(10, 10, 0, 0);
//        city5.add(this.city5NameLabel, c);
//        this.city5NameLabel.setFont(ImportFont.getFont("Medium", 20));
//        this.city5NameLabel.setForeground(Color.decode("#FFFFFF"));
//
//        c.gridx = 0;
//        c.gridy = 1;
//        c.insets = new Insets(1, 10, 8, 0);
//        city5.add(this.city5WeatherConditionLabel, c);
//        this.city5WeatherConditionLabel.setFont(ImportFont.getFont("Light", 14));
//        this.city5WeatherConditionLabel.setForeground(Color.decode("#FFFFFF"));
//
//        c.gridx = 1;
//        c.gridy = 0;
//        c.gridheight = 2;
//        c.insets = new Insets(10, 0, 11, 10);
//        c.anchor = GridBagConstraints.EAST;
//        city5.add(this.city5TemperatureLabel, c);
//        this.city5TemperatureLabel.setFont(ImportFont.getFont("Medium", 32));
//        this.city5TemperatureLabel.setForeground(Color.decode("#FFFFFF"));
//
//        this.add(city5, constraints);
//        constraints.gridy = 6;
//
//        c.anchor = GridBagConstraints.WEST;
//        RoundedPanel city6 = new RoundedPanel(20);
//        city6.setLayout(new GridBagLayout());
//        city6.setPreferredSize(new Dimension(240, 60));
//        city6.setBackground(Color.decode("#2A3540"));
//        c.gridx = 0;
//        c.gridy = 0;
//        c.insets = new Insets(10, 10, 0, 0);
//        city6.add(this.city6NameLabel, c);
//        this.city6NameLabel.setFont(ImportFont.getFont("Medium", 20));
//        this.city6NameLabel.setForeground(Color.decode("#FFFFFF"));
//
//        c.gridx = 0;
//        c.gridy = 1;
//        c.insets = new Insets(1, 10, 8, 0);
//        city6.add(this.city6WeatherConditionLabel, c);
//        this.city6WeatherConditionLabel.setFont(ImportFont.getFont("Light", 14));
//        this.city6WeatherConditionLabel.setForeground(Color.decode("#FFFFFF"));
//
//        c.gridx = 1;
//        c.gridy = 0;
//        c.gridheight = 2;
//        c.insets = new Insets(10, 0, 11, 10);
//        c.anchor = GridBagConstraints.EAST;
//        city6.add(this.city6TemperatureLabel, c);
//        this.city6TemperatureLabel.setFont(ImportFont.getFont("Medium", 32));
//        this.city6TemperatureLabel.setForeground(Color.decode("#FFFFFF"));
//
//        this.add(city6, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.viewMapButton) {
            System.out.println("View Map button clicked");
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(viewName)) {
            OtherCitiesState state = otherCitiesViewModel.getState();
            this.city1NameLabel.setText(state.getOtherCitiesWeather().get(0).getCityName());
            this.city1WeatherConditionLabel.setText(state.getOtherCitiesWeather().get(0).getWeatherCondition());
            this.city1TemperatureLabel.setText(state.getOtherCitiesWeather().get(0).getTemperature());

            this.city2NameLabel.setText(state.getOtherCitiesWeather().get(1).getCityName());
            this.city2WeatherConditionLabel.setText(state.getOtherCitiesWeather().get(1).getWeatherCondition());
            this.city2TemperatureLabel.setText(state.getOtherCitiesWeather().get(1).getTemperature());

            this.city3NameLabel.setText(state.getOtherCitiesWeather().get(2).getCityName());
            this.city3WeatherConditionLabel.setText(state.getOtherCitiesWeather().get(2).getWeatherCondition());
            this.city3TemperatureLabel.setText(state.getOtherCitiesWeather().get(2).getTemperature());

            this.city4NameLabel.setText(state.getOtherCitiesWeather().get(3).getCityName());
            this.city4WeatherConditionLabel.setText(state.getOtherCitiesWeather().get(3).getWeatherCondition());
            this.city4TemperatureLabel.setText(state.getOtherCitiesWeather().get(3).getTemperature());

            this.city5NameLabel.setText(state.getOtherCitiesWeather().get(4).getCityName());
            this.city5WeatherConditionLabel.setText(state.getOtherCitiesWeather().get(4).getWeatherCondition());
            this.city5TemperatureLabel.setText(state.getOtherCitiesWeather().get(4).getTemperature());

            this.city6NameLabel.setText(state.getOtherCitiesWeather().get(5).getCityName());
            this.city6WeatherConditionLabel.setText(state.getOtherCitiesWeather().get(5).getWeatherCondition());
            this.city6TemperatureLabel.setText(state.getOtherCitiesWeather().get(5).getTemperature());
        }
    }
}
