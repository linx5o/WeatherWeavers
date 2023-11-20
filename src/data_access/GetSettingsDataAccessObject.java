package data_access;

import entity.Settings;
import entity.Weather;
import use_case.forecast.ForecastDataAccessInterface;
import use_case.forecast.ForecastSettingsDataAccessInterface;
import use_case.get_weather.GetSettingsDataAccessInterface;
import use_case.hourly.HourlySettingsDataAccessInterface;

import java.util.List;

public class GetSettingsDataAccessObject implements GetSettingsDataAccessInterface, HourlySettingsDataAccessInterface, ForecastSettingsDataAccessInterface {
    @Override
    public Settings getSettings() {
        return null;
    }
}
