package use_case.get_weather_on_map;

import entity.Location;
import entity.Weather;
import view.RoundedPanel;

import javax.swing.*;

public interface GetWeatherOnMapDataAccessInterface {
    RoundedPanel getWeatherOnMap();
}
