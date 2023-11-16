package app;

import interface_adapter.Cities.CitiesViewModel;
import interface_adapter.ForecastViewModel;
import interface_adapter.GetWeather.GetWeatherViewModel;
import interface_adapter.GetWeather.HourlyViewModel;
import interface_adapter.GetWeather.OtherCitiesViewModel;
import interface_adapter.Map.MapViewModel;
import interface_adapter.Settings.SettingsViewModel;
import use_case.get_weather.GetSettingsDataAccessInterface;
import use_case.get_weather.GetWeatherDataAccessInterface;
import view.ViewManager;
import view.Weather.GetWeatherView;
import view.Weather.WeatherView;

import javax.swing.*;

public class WeatherFactory {
    private WeatherFactory() {}

    public static WeatherView create(ViewManager viewManager, GetWeatherViewModel getWeatherViewModel, GetWeatherDataAccessInterface getWeatherDataAccessObject, GetSettingsDataAccessInterface getSettingsDataAccessObject, HourlyViewModel hourlyViewModel, HourlyDataAccessInterface hourlyDataAccessObject, OtherCitiesViewModel otherCitiesViewModel, OtherCitiesDataAccessInterface otherCitiesDataAccessObject, OtherCitiesListDataAccessInterface otherCitiesListDataAccessObject, ForecastViewModel forecastViewModel, ForecastDataAccessInterface forecastDataAccessObject, CitiesViewModel citiesViewModel, MapViewModel mapViewModel, SettingsViewModel settingsViewModel) {
        try {
            GetWeatherView getWeatherView = GetWeatherUseCaseFactory.create(getWeatherViewModel, getWeatherDataAccessObject, getSettingsDataAccessObject);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Could not open settings file");
        }

        return null;
    }
}