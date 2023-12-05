package app;

import data_access.GetSettingsDataAccessObject;
import interface_adapter.Forecast.ForecastViewModel;
import interface_adapter.Cities.CitiesViewModel;
import interface_adapter.GetWeather.GetWeatherViewModel;
import interface_adapter.Hourly.HourlyViewModel;
import interface_adapter.Humidity.HumidityViewModel;
import interface_adapter.OtherCities.OtherCitiesViewModel;
import interface_adapter.GetWeatherOnMap.GetWeatherOnMapViewModel;
import interface_adapter.Settings.SettingsViewModel;
import interface_adapter.WeatherViewModel;
import use_case.forecast.ForecastDataAccessInterface;
import use_case.get_other_cities.GetOtherCitiesDataAccessInterface;
import use_case.get_weather.GetWeatherDataAccessInterface;
import use_case.hourly.HourlyDataAccessInterface;
import use_case.humidity.HumidityDataAccessInterface;
import view.ViewManager;
import view.weather.*;

import javax.swing.*;

public class WeatherFactory {
    private WeatherFactory() {}


    public static WeatherView create(ViewManager viewManager, GetWeatherViewModel getWeatherViewModel, GetWeatherDataAccessInterface getWeatherDataAccessObject, GetSettingsDataAccessObject getSettingsDataAccessObject, HourlyViewModel hourlyViewModel, HourlyDataAccessInterface hourlyDataAccessObject, HumidityViewModel humidityViewModel, HumidityDataAccessInterface humidityDataAccessObject, OtherCitiesViewModel otherCitiesViewModel, GetOtherCitiesDataAccessInterface otherCitiesDataAccessObject, ForecastViewModel forecastViewModel, ForecastDataAccessInterface forecastDataAccessObject, CitiesViewModel citiesViewModel, GetWeatherOnMapViewModel mapViewModel, SettingsViewModel settingsViewModel, WeatherViewModel weatherViewModel) {

        try {
            GetWeatherView getWeatherView = GetWeatherUseCaseFactory.create(getWeatherViewModel, getWeatherDataAccessObject, getSettingsDataAccessObject);
            HourlyView hourlyView = HourlyUseCaseFactory.create(hourlyViewModel, hourlyDataAccessObject, getSettingsDataAccessObject);
            HumidityView humidityView = HumidityUseCaseFactory.create(humidityViewModel, humidityDataAccessObject, getSettingsDataAccessObject);
            OtherCitiesView otherCitiesView = OtherCitiesUseCaseFactory.create(otherCitiesViewModel, otherCitiesDataAccessObject, getSettingsDataAccessObject);
            ForecastView forecastView = ForecastUseCaseFactory.create(forecastViewModel, forecastDataAccessObject, getSettingsDataAccessObject);

            return new WeatherView(getWeatherView, hourlyView, humidityView, otherCitiesView, forecastView, weatherViewModel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Could not open settings file");
        }

        return null;
    }
}
