package app;

import data_access.*;
import interface_adapter.Cities.CitiesViewModel;
import interface_adapter.Forecast.ForecastViewModel;
import interface_adapter.GetWeather.GetWeatherViewModel;
import interface_adapter.GetWeatherOnMap.GetWeatherOnMapViewModel;
import interface_adapter.Hourly.HourlyViewModel;
import interface_adapter.Humidity.HumidityViewModel;
import interface_adapter.OtherCities.OtherCitiesViewModel;
import interface_adapter.Settings.SettingsViewModel;
import interface_adapter.Sidebar.SidebarViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.WeatherViewModel;
import org.junit.Before;
import org.junit.Test;
import use_case.forecast.ForecastDataAccessInterface;
import use_case.get_other_cities.GetOtherCitiesDataAccessInterface;
import use_case.get_weather.GetWeatherDataAccessInterface;
import use_case.hourly.HourlyDataAccessInterface;
import use_case.humidity.HumidityDataAccessInterface;
import view.ViewManager;
import view.settings.SettingsView;
import view.sidebar.SidebarView;
import view.weather.WeatherView;

import javax.swing.*;
import java.awt.*;

public class MainTest {
    @Test
    public void testMain() {
        try {
            Main.main(new String[]{}); // Run the main method
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
