package view.weather;

import app.ImportFont;
import interface_adapter.Forecast.ForecastController;
import interface_adapter.Forecast.ForecastState;
import interface_adapter.Forecast.ForecastViewModel;
import view.RoundedPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ForecastView extends RoundedPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "forecast";

    private final JLabel forecast1 = new JLabel();
    private final JLabel forecast1Temp = new JLabel();
    private final JLabel forecast1Icon = new JLabel();

    private final JLabel forecast2 = new JLabel();
    private final JLabel forecast2Temp = new JLabel();
    private final JLabel forecast2Icon = new JLabel();

    private final JLabel forecast3 = new JLabel();
    private final JLabel forecast3Temp = new JLabel();
    private final JLabel forecast3Icon = new JLabel();

    private final JLabel forecast4 = new JLabel();
    private final JLabel forecast4Temp = new JLabel();
    private final JLabel forecast4Icon = new JLabel();

    private final JLabel forecast5 = new JLabel();
    private final JLabel forecast5Temp = new JLabel();
    private final JLabel forecast5Icon = new JLabel();

    private final JLabel forecast6 = new JLabel();
    private final JLabel forecast6Temp = new JLabel();
    private final JLabel forecast6Icon = new JLabel();

    private final JLabel forecast7 = new JLabel();
    private final JLabel forecast7Temp = new JLabel();
    private final JLabel forecast7Icon = new JLabel();

    private final JLabel forecast8 = new JLabel();
    private final JLabel forecast8Temp = new JLabel();
    private final JLabel forecast8Icon = new JLabel();

    private final JLabel forecast9 = new JLabel();
    private final JLabel forecast9Temp = new JLabel();
    private final JLabel forecast9Icon = new JLabel();

    private final ForecastController controller;
    private final ForecastViewModel forecastViewModel;

    public ForecastView(ForecastController controller, ForecastViewModel forecastViewModel) {
        super(40);
        this.controller = controller;
        this.forecastViewModel = forecastViewModel;

        this.setPreferredSize(new Dimension(900, 120));
        this.setBackground(Color.decode("#222B3A"));

//        this.controller.execute();
        forecastViewModel.addPropertyChangeListener(this);

        ForecastState state = forecastViewModel.getState();

        this.forecast1.setText(state.getForecast1());
        this.forecast1Temp.setText(state.getForecast1Temp());
        this.forecast1Icon.setIcon(state.getForecast1Icon());

        this.forecast2.setText(state.getForecast2());
        this.forecast2Temp.setText(state.getForecast2Temp());
        this.forecast2Icon.setIcon(state.getForecast2Icon());

        this.forecast3.setText(state.getForecast3());
        this.forecast3Temp.setText(state.getForecast3Temp());
        this.forecast3Icon.setIcon(state.getForecast3Icon());

        this.forecast4.setText(state.getForecast4());
        this.forecast4Temp.setText(state.getForecast4Temp());
        this.forecast4Icon.setIcon(state.getForecast4Icon());

        this.forecast5.setText(state.getForecast5());
        this.forecast5Temp.setText(state.getForecast5Temp());
        this.forecast5Icon.setIcon(state.getForecast5Icon());

        this.forecast6.setText(state.getForecast6());
        this.forecast6Temp.setText(state.getForecast6Temp());
        this.forecast6Icon.setIcon(state.getForecast6Icon());

        this.forecast7.setText(state.getForecast7());
        this.forecast7Temp.setText(state.getForecast7Temp());
        this.forecast7Icon.setIcon(state.getForecast7Icon());

        this.forecast8.setText(state.getForecast8());
        this.forecast8Temp.setText(state.getForecast8Temp());
        this.forecast8Icon.setIcon(state.getForecast8Icon());

        this.forecast9.setText(state.getForecast9());
        this.forecast9Temp.setText(state.getForecast9Temp());
        this.forecast9Icon.setIcon(state.getForecast9Icon());

        this.forecast1.setText("Wed");
        this.forecast1Temp.setText("23° / 27°");
        this.forecast1Icon.setIcon(new ImageIcon(new ImageIcon("src/interface_adapter/GetWeather/icons/" + "sunny.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        RoundedPanel forecast1Panel = new RoundedPanel(20);
        RoundedPanel forecast2Panel = new RoundedPanel(20);
        RoundedPanel forecast3Panel = new RoundedPanel(20);
        RoundedPanel forecast4Panel = new RoundedPanel(20);
        RoundedPanel forecast5Panel = new RoundedPanel(20);
        RoundedPanel forecast6Panel = new RoundedPanel(20);
        RoundedPanel forecast7Panel = new RoundedPanel(20);
        RoundedPanel forecast8Panel = new RoundedPanel(20);
        RoundedPanel forecast9Panel = new RoundedPanel(20);

        forecast1Panel.setPreferredSize(new Dimension(80, 100));
        forecast2Panel.setPreferredSize(new Dimension(80, 100));
        forecast3Panel.setPreferredSize(new Dimension(80, 100));
        forecast4Panel.setPreferredSize(new Dimension(80, 100));
        forecast5Panel.setPreferredSize(new Dimension(80, 100));
        forecast6Panel.setPreferredSize(new Dimension(80, 100));
        forecast7Panel.setPreferredSize(new Dimension(80, 100));
        forecast8Panel.setPreferredSize(new Dimension(80, 100));
        forecast9Panel.setPreferredSize(new Dimension(80, 100));

        forecast1Panel.setBackground(Color.decode("#2A3540"));
        forecast2Panel.setBackground(Color.decode("#2A3540"));
        forecast3Panel.setBackground(Color.decode("#2A3540"));
        forecast4Panel.setBackground(Color.decode("#2A3540"));
        forecast5Panel.setBackground(Color.decode("#2A3540"));
        forecast6Panel.setBackground(Color.decode("#2A3540"));
        forecast7Panel.setBackground(Color.decode("#2A3540"));
        forecast8Panel.setBackground(Color.decode("#2A3540"));
        forecast9Panel.setBackground(Color.decode("#2A3540"));

        forecast1Panel.setLayout(new GridBagLayout());
        forecast2Panel.setLayout(new GridBagLayout());
        forecast3Panel.setLayout(new GridBagLayout());
        forecast4Panel.setLayout(new GridBagLayout());
        forecast5Panel.setLayout(new GridBagLayout());
        forecast6Panel.setLayout(new GridBagLayout());
        forecast7Panel.setLayout(new GridBagLayout());
        forecast8Panel.setLayout(new GridBagLayout());
        forecast9Panel.setLayout(new GridBagLayout());

//        forecast1Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        forecast2Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        forecast3Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        forecast4Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        forecast5Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        forecast6Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        forecast7Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        forecast8Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        forecast9Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

//        layout.setAutoCreateGaps(true);
//        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGap(10)
                        .addComponent(forecast1Panel)
                        .addGap(20)
                        .addComponent(forecast2Panel)
                        .addGap(20)
                        .addComponent(forecast3Panel)
                        .addGap(20)
                        .addComponent(forecast4Panel)
                        .addGap(20)
                        .addComponent(forecast5Panel)
                        .addGap(20)
                        .addComponent(forecast6Panel)
                        .addGap(20)
                        .addComponent(forecast7Panel)
                        .addGap(20)
                        .addComponent(forecast8Panel)
                        .addGap(20)
                        .addComponent(forecast9Panel)
                        .addGap(10)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGap(10)
                        .addGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(forecast1Panel)
                                        .addComponent(forecast2Panel)
                                        .addComponent(forecast3Panel)
                                        .addComponent(forecast4Panel)
                                        .addComponent(forecast5Panel)
                                        .addComponent(forecast6Panel)
                                        .addComponent(forecast7Panel)
                                        .addComponent(forecast8Panel)
                                        .addComponent(forecast9Panel)
                        )
                        .addGap(10)
        );

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 7, 0);
        forecast1Panel.add(forecast1, constraints);
        forecast1.setFont(ImportFont.getFont("ExtraLight", 16));
        forecast1.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 1;
        forecast1Panel.add(forecast1Temp, constraints);
        forecast1Temp.setFont(ImportFont.getFont("Medium", 14));
        forecast1Temp.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(0, 0, 0, 0);
        forecast1Panel.add(forecast1Icon, constraints);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 7, 0);
        forecast2Panel.add(forecast2, constraints);
        forecast2.setFont(ImportFont.getFont("ExtraLight", 16));
        forecast2.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 1;
        forecast2Panel.add(forecast2Temp, constraints);
        forecast2Temp.setFont(ImportFont.getFont("Medium", 14));
        forecast2Temp.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(0, 0, 0, 0);
        forecast2Panel.add(forecast2Icon, constraints);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 7, 0);
        forecast3Panel.add(forecast3, constraints);
        forecast3.setFont(ImportFont.getFont("ExtraLight", 16));
        forecast3.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 1;
        forecast3Panel.add(forecast3Temp, constraints);
        forecast3Temp.setFont(ImportFont.getFont("Medium", 14));
        forecast3Temp.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(0, 0, 0, 0);
        forecast3Panel.add(forecast3Icon, constraints);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 7, 0);
        forecast4Panel.add(forecast4, constraints);
        forecast4.setFont(ImportFont.getFont("ExtraLight", 16));
        forecast4.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 1;
        forecast4Panel.add(forecast4Temp, constraints);
        forecast4Temp.setFont(ImportFont.getFont("Medium", 14));
        forecast4Temp.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(0, 0, 0, 0);
        forecast4Panel.add(forecast4Icon, constraints);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 7, 0);
        forecast5Panel.add(forecast5, constraints);
        forecast5.setFont(ImportFont.getFont("ExtraLight", 16));
        forecast5.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 1;
        forecast5Panel.add(forecast5Temp, constraints);
        forecast5Temp.setFont(ImportFont.getFont("Medium", 14));
        forecast5Temp.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(0, 0, 0, 0);
        forecast5Panel.add(forecast5Icon, constraints);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 7, 0);
        forecast6Panel.add(forecast6, constraints);
        forecast6.setFont(ImportFont.getFont("ExtraLight", 16));
        forecast6.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 1;
        forecast6Panel.add(forecast6Temp, constraints);
        forecast6Temp.setFont(ImportFont.getFont("Medium", 14));
        forecast6Temp.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(0, 0, 0, 0);
        forecast6Panel.add(forecast6Icon, constraints);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 7, 0);
        forecast7Panel.add(forecast7, constraints);
        forecast7.setFont(ImportFont.getFont("ExtraLight", 16));
        forecast7.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 1;
        forecast7Panel.add(forecast7Temp, constraints);
        forecast7Temp.setFont(ImportFont.getFont("Medium", 14));
        forecast7Temp.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(0, 0, 0, 0);
        forecast7Panel.add(forecast7Icon, constraints);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 7, 0);
        forecast8Panel.add(forecast8, constraints);
        forecast8.setFont(ImportFont.getFont("ExtraLight", 16));
        forecast8.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 1;
        forecast8Panel.add(forecast8Temp, constraints);
        forecast8Temp.setFont(ImportFont.getFont("Medium", 14));
        forecast8Temp.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(0, 0, 0, 0);
        forecast8Panel.add(forecast8Icon, constraints);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 7, 0);
        forecast9Panel.add(forecast9, constraints);
        forecast9.setFont(ImportFont.getFont("ExtraLight", 16));
        forecast9.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 1;
        forecast9Panel.add(forecast9Temp, constraints);
        forecast9Temp.setFont(ImportFont.getFont("Medium", 14));
        forecast9Temp.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(0, 0, 0, 0);
        forecast9Panel.add(forecast9Icon, constraints);
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
