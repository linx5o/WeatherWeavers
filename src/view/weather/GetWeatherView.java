package view.weather;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.DataInput;
import java.time.LocalTime;

import app.ImportFont;
import interface_adapter.GetWeather.GetWeatherController;
import interface_adapter.GetWeather.GetWeatherState;
import interface_adapter.GetWeather.GetWeatherViewModel;

public class GetWeatherView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "get weather";

    private final JLabel city = new JLabel();
    private final JLabel date = new JLabel();
    private final JLabel temperatureIcon = new JLabel();
    private final JLabel temperature = new JLabel();
    private final JLabel temperatureLabel = new JLabel();
    private final JLabel high = new JLabel();
    private final JLabel low = new JLabel();
    private final JLabel wind = new JLabel();
    private final JLabel rain = new JLabel();
    private final JLabel sunrise = new JLabel();
    private final JLabel sunset = new JLabel();

    private final GetWeatherController controller;
    private final GetWeatherViewModel getWeatherViewModel;


    public GetWeatherView(GetWeatherController controller, GetWeatherViewModel getWeatherViewModel) {
        this.controller = controller;
        this.getWeatherViewModel = getWeatherViewModel;

        this.setPreferredSize(new Dimension(620, 260));

        this.controller.execute();
        getWeatherViewModel.addPropertyChangeListener(this);

        GetWeatherState state = getWeatherViewModel.getState();

        this.city.setText(state.getCity());
        this.date.setText(state.getDate());
        this.temperatureIcon.setIcon(state.getTemperatureIcon());
        this.temperature.setText(state.getTemperature());
        this.temperatureLabel.setText(state.getDescription());
        this.high.setText(state.getHigh());
        this.low.setText(state.getLow());
        this.wind.setText(state.getWind());
        this.rain.setText(state.getRain());
        this.sunrise.setText(state.getSunrise());
        this.sunset.setText(state.getSunset());

//        ImageIcon icon = new ImageIcon("src/interface_adapter/GetWeather/icons/sunny.png");
//        this.city.setText("Toronto");
//        this.date.setText("Monday, 21 November");
//        this.temperatureIcon.setIcon(icon);
//        this.temperature.setText("8°");
//        this.temperatureLabel.setText("Sunny");
//        this.low.setText("7°");
//        this.high.setText("9°");
//        this.wind.setText("3 KM/H");
//        this.rain.setText("4%");
//        this.sunrise.setText("6:32");
//        this.sunset.setText("18:12");

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.decode("#0D131D"));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.insets = new Insets(20, 20, 0, 0);
        this.add(city, constraints);
        city.setFont(ImportFont.getFont("Medium", 32));
        city.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.insets = new Insets(0, 20, 0, 0);
        this.add(date, constraints);
        date.setFont(ImportFont.getFont("ExtraLight", 14));
        date.setForeground(Color.decode("#FFFFFF"));

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(20,40,20, 20);
        JPanel temperatureIconPanel = new JPanel();
        temperatureIconPanel.setBackground(Color.decode("#0D131D"));
        temperatureIconPanel.setPreferredSize(new Dimension(140, 140));
        temperatureIconPanel.setLayout(new BoxLayout(temperatureIconPanel, BoxLayout.LINE_AXIS));
        temperatureIconPanel.add(temperatureIcon);

//        temperatureIconPanel.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
//        temperatureIcon.setVerticalAlignment(JLabel.CENTER);
//        temperatureIcon.setHorizontalAlignment(JLabel.CENTER);
        this.add(temperatureIconPanel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.insets = new Insets(20, 200, 20, 0);
        JPanel temperaturePanel = new JPanel();
        temperaturePanel.setLayout(new GridBagLayout());
        temperaturePanel.setBackground(Color.decode("#0D131D"));
        temperaturePanel.setPreferredSize(new Dimension(140, 140));

        GridBagConstraints temperatureConstraints = new GridBagConstraints();
        temperatureConstraints.gridx = 0;
        temperatureConstraints.gridy = 0;
        temperatureConstraints.insets = new Insets(20, 0, 3, 0);
        temperaturePanel.add(temperature, temperatureConstraints);
//        temperaturePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        temperature.setFont(ImportFont.getFont("Regular", 64));
        temperature.setForeground(Color.decode("#FFFFFF"));
//        temperature.setBorder(BorderFactory.createLineBorder(Color.green, 2));
        temperatureConstraints.gridx = 0;
        temperatureConstraints.gridy = 1;
        temperatureConstraints.insets = new Insets(0, 0, 21, 0);
        temperaturePanel.add(temperatureLabel, temperatureConstraints);
        temperatureLabel.setFont(ImportFont.getFont("Light", 16));
        temperatureLabel.setForeground(Color.decode("#FFFFFF"));
//        temperatureLabel.setBorder(BorderFactory.createLineBorder(Color.red, 2));

        this.add(temperaturePanel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.insets = new Insets(0, 340, 0, 19);
        JPanel line = new JPanel();
        line.setBackground(Color.decode("#CCCFD4"));
        line.setPreferredSize(new Dimension(1, 140));
//        line.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        this.add(line, constraints);

        constraints.gridx = 3;
        constraints.gridy = 2;
        constraints.weightx = 1;
        constraints.insets = new Insets(0, 160, 0, 0);
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(2, 3));
        detailsPanel.setBackground(Color.decode("#0D131D"));
//        detailsPanel.setBackground(Color.green);
        detailsPanel.setPreferredSize(new Dimension(240, 140));

        JPanel highPanel = new JPanel();
        highPanel.setLayout(new GridBagLayout());
        highPanel.setBackground(Color.decode("#0D131D"));
        highPanel.setPreferredSize(new Dimension(80, 70));
        GridBagConstraints highConstraints = new GridBagConstraints();
        highConstraints.gridx = 0;
        highConstraints.gridy = 0;
        highConstraints.insets = new Insets(0, 0, 3, 0);
        highPanel.add(high, highConstraints);
        high.setFont(ImportFont.getFont("Medium", 16));
        high.setForeground(Color.decode("#FFFFFF"));
        highConstraints.gridx = 0;
        highConstraints.gridy = 1;
        highConstraints.insets = new Insets(0, 0, 0, 0);
        JLabel highLabel = new JLabel("High");
        highLabel.setFont(ImportFont.getFont("Light", 12));
        highLabel.setForeground(Color.decode("#D9D9D9"));
        highPanel.add(highLabel, highConstraints);

        JPanel lowPanel = new JPanel();
        lowPanel.setLayout(new GridBagLayout());
        lowPanel.setBackground(Color.decode("#0D131D"));
        lowPanel.setPreferredSize(new Dimension(80, 70));
        GridBagConstraints lowConstraints = new GridBagConstraints();
        lowConstraints.gridx = 0;
        lowConstraints.gridy = 0;
        lowConstraints.insets = new Insets(0, 0, 3, 0);
        lowPanel.add(low, lowConstraints);
        low.setFont(ImportFont.getFont("Medium", 16));
        low.setForeground(Color.decode("#FFFFFF"));
        lowConstraints.gridx = 0;
        lowConstraints.gridy = 1;
        lowConstraints.insets = new Insets(0, 0, 0, 0);
        JLabel lowLabel = new JLabel("Low");
        lowLabel.setFont(ImportFont.getFont("Light", 12));
        lowLabel.setForeground(Color.decode("#D9D9D9"));
        lowPanel.add(lowLabel, lowConstraints);

        JPanel windPanel = new JPanel();
        windPanel.setLayout(new GridBagLayout());
        windPanel.setBackground(Color.decode("#0D131D"));
        windPanel.setPreferredSize(new Dimension(80, 70));
        GridBagConstraints windConstraints = new GridBagConstraints();
        windConstraints.gridx = 0;
        windConstraints.gridy = 0;
        windConstraints.insets = new Insets(0, 0, 3, 0);
        windPanel.add(wind, windConstraints);
        wind.setFont(ImportFont.getFont("Medium", 16));
        wind.setForeground(Color.decode("#FFFFFF"));
        windConstraints.gridx = 0;
        windConstraints.gridy = 1;
        windConstraints.insets = new Insets(0, 0, 0, 0);
        JLabel windLabel = new JLabel("Wind");
        windLabel.setFont(ImportFont.getFont("Light", 12));
        windLabel.setForeground(Color.decode("#D9D9D9"));
        windPanel.add(windLabel, windConstraints);

        JPanel rainPanel = new JPanel();
        rainPanel.setLayout(new GridBagLayout());
        rainPanel.setBackground(Color.decode("#0D131D"));
        rainPanel.setPreferredSize(new Dimension(80, 70));
        GridBagConstraints rainConstraints = new GridBagConstraints();
        rainConstraints.gridx = 0;
        rainConstraints.gridy = 0;
        rainConstraints.insets = new Insets(0, 0, 3, 0);
        rainPanel.add(rain, rainConstraints);
        rain.setFont(ImportFont.getFont("Medium", 16));
        rain.setForeground(Color.decode("#FFFFFF"));
        rainConstraints.gridx = 0;
        rainConstraints.gridy = 1;
        rainConstraints.insets = new Insets(0, 0, 0, 0);
        JLabel rainLabel = new JLabel("Rain");
        rainLabel.setFont(ImportFont.getFont("Light", 12));
        rainLabel.setForeground(Color.decode("#D9D9D9"));
        rainPanel.add(rainLabel, rainConstraints);

        JPanel sunrisePanel = new JPanel();
        sunrisePanel.setLayout(new GridBagLayout());
        sunrisePanel.setBackground(Color.decode("#0D131D"));
        sunrisePanel.setPreferredSize(new Dimension(80, 70));
        GridBagConstraints sunriseConstraints = new GridBagConstraints();
        sunriseConstraints.gridx = 0;
        sunriseConstraints.gridy = 0;
        sunriseConstraints.insets = new Insets(0, 0, 3, 0);
        sunrisePanel.add(sunrise, sunriseConstraints);
        sunrise.setFont(ImportFont.getFont("Medium", 16));
        sunrise.setForeground(Color.decode("#FFFFFF"));
        sunriseConstraints.gridx = 0;
        sunriseConstraints.gridy = 1;
        sunriseConstraints.insets = new Insets(0, 0, 0, 0);
        JLabel sunriseLabel = new JLabel("Sunrise");
        sunriseLabel.setFont(ImportFont.getFont("Light", 12));
        sunriseLabel.setForeground(Color.decode("#D9D9D9"));
        sunrisePanel.add(sunriseLabel, sunriseConstraints);

        JPanel sunsetPanel = new JPanel();
        sunsetPanel.setLayout(new GridBagLayout());
        sunsetPanel.setBackground(Color.decode("#0D131D"));
        sunsetPanel.setPreferredSize(new Dimension(80, 70));
        GridBagConstraints sunsetConstraints = new GridBagConstraints();
        sunsetConstraints.gridx = 0;
        sunsetConstraints.gridy = 0;
        sunsetConstraints.insets = new Insets(0, 0, 3, 0);
        sunsetPanel.add(sunset, sunsetConstraints);
        sunset.setFont(ImportFont.getFont("Medium", 16));
        sunset.setForeground(Color.decode("#FFFFFF"));
        sunsetConstraints.gridx = 0;
        sunsetConstraints.gridy = 1;
        sunsetConstraints.insets = new Insets(0, 0, 0, 0);
        JLabel sunsetLabel = new JLabel("Sunset");
        sunsetLabel.setFont(ImportFont.getFont("Light", 12));
        sunsetLabel.setForeground(Color.decode("#D9D9D9"));
        sunsetPanel.add(sunsetLabel, sunsetConstraints);

        detailsPanel.add(highPanel);
        detailsPanel.add(windPanel);
        detailsPanel.add(sunrisePanel);
        detailsPanel.add(lowPanel);
        detailsPanel.add(rainPanel);
        detailsPanel.add(sunsetPanel);

        this.add(detailsPanel, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // TODO
    }
}
