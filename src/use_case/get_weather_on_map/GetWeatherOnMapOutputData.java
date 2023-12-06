package use_case.get_weather_on_map;

import view.RoundedPanel;

import javax.swing.*;

public class GetWeatherOnMapOutputData {
    private final RoundedPanel panel;

    public GetWeatherOnMapOutputData(RoundedPanel panel) {
        this.panel = panel;
    }

    public RoundedPanel getPanel() {
        return panel;
    }
}
