package use_case.get_weather_on_map;

import javax.swing.*;

public class GetWeatherOnMapOutputData {
    private final JPanel panel;

    public GetWeatherOnMapOutputData(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getPanel() {
        return panel;
    }
}
