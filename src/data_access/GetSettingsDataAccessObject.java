package data_access;

import entity.Settings;
import entity.Weather;
import use_case.forecast.ForecastDataAccessInterface;
import use_case.forecast.ForecastSettingsDataAccessInterface;
import use_case.get_other_cities.GetOtherCitiesDataAccessInterface;
import use_case.get_other_cities.OtherCitiesSettingsDataAccessInterface;
import use_case.get_weather.GetSettingsDataAccessInterface;
import use_case.hourly.HourlySettingsDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class GetSettingsDataAccessObject implements GetSettingsDataAccessInterface, HourlySettingsDataAccessInterface, ForecastSettingsDataAccessInterface, OtherCitiesSettingsDataAccessInterface {
    @Override
    public Settings getSettings() {
        return new Settings(true, true, true, "toronto,ca", new ArrayList<>());
    }
}
