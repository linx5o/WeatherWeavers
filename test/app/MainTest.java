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
    @Before
    public void setUp() {
        WeatherViewModel weatherViewModel = new WeatherViewModel();
        GetWeatherViewModel getWeatherViewModel = new GetWeatherViewModel();
        OtherCitiesViewModel otherCitiesViewModel = new OtherCitiesViewModel();
        HourlyViewModel hourlyViewModel = new HourlyViewModel();
        HumidityViewModel humidityViewModel = new HumidityViewModel();
        ForecastViewModel forecastViewModel = new ForecastViewModel();

        CitiesViewModel citiesViewModel = new CitiesViewModel();
        GetWeatherOnMapViewModel mapViewModel = new GetWeatherOnMapViewModel();
        SettingsViewModel settingsViewModel = new SettingsViewModel();
        SidebarViewModel sideBarViewModel = new SidebarViewModel();


        // Define Data Access Objects
        GetWeatherDataAccessInterface getWeatherDataAccessObject = new GetWeatherDataAccessObject();
        GetSettingsDataAccessObject getSettingsDataAccessObject = new GetSettingsDataAccessObject();

        HourlyDataAccessInterface hourlyDataAccessObject = new HourlyDataAccessObject();
        HumidityDataAccessInterface humidityDataAccessObject = new HumidityDataAccessObject();
        GetOtherCitiesDataAccessInterface otherCitiesDataAccessObject = new OtherCitiesDataAccessObject();
        ForecastDataAccessInterface forecastDataAccessObject = new ForecastDataAccessObject();
        SettingsDataAccessObject settingsDataAccessObject = new SettingsDataAccessObject();

        // Define Content View Manager
        CardLayout cardLayout = new CardLayout();
        JPanel content = new JPanel(cardLayout);

        ViewManagerModel mainContentViewManagerModel = new ViewManagerModel();
        ViewManager mainContentViewManager = new ViewManager(content, cardLayout, mainContentViewManagerModel);


        // The main application view.
        JPanel main = new JPanel(new BorderLayout());

        // Sidebar Menu
        JPanel sidebar = new JPanel(new GridBagLayout());
        sidebar.setPreferredSize(new Dimension(100, 700));
        main.add(sidebar, BorderLayout.WEST);

        SidebarView sidebarView = SidebarUseCaseFactory.create(sideBarViewModel, getWeatherViewModel, citiesViewModel, mapViewModel, settingsViewModel, mainContentViewManagerModel, weatherViewModel, humidityViewModel, hourlyViewModel, forecastViewModel, otherCitiesViewModel);
        sidebar.add(sidebarView);

//        JPanel sidebarPlaceHolder = new JPanel();
//        sidebarPlaceHolder.setPreferredSize(new Dimension(100, 700));
//        sidebarPlaceHolder.setBackground(Color.decode("#0D131D"));
//        sidebar.add(sidebarPlaceHolder);
//        JButton button = new JButton("Button");
//        sidebarPlaceHolder.add(button);
//        JLabel label = new JLabel("Label");
//        label.setFont(ImportFont.getFont("Thin", 30));
//        sidebarPlaceHolder.add(label);


        // Main Side
        JPanel mainSide = new JPanel(new BorderLayout());
        mainSide.setPreferredSize(new Dimension(920, 700));
        main.add(mainSide, BorderLayout.CENTER);

        // Search Bar
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 0, 0);
        JPanel search = new JPanel(flowLayout);
        search.setPreferredSize(new Dimension(920, 80));
        mainSide.add(search, BorderLayout.NORTH);

//        SearchView searchView = SearchUseCaseFactory.create(searchViewModel, citiesViewModel);
//        search.add(searchView);

        JPanel searchPlaceHolder = new JPanel();
        searchPlaceHolder.setPreferredSize(new Dimension(920, 80));
        searchPlaceHolder.setBackground(Color.cyan);
        search.add(searchPlaceHolder);


        // Main Content
        mainSide.add(content, BorderLayout.CENTER);

        WeatherView weatherView = WeatherFactory.create(mainContentViewManager, getWeatherViewModel, getWeatherDataAccessObject, getSettingsDataAccessObject, hourlyViewModel, hourlyDataAccessObject, humidityViewModel, humidityDataAccessObject, otherCitiesViewModel, otherCitiesDataAccessObject, forecastViewModel, forecastDataAccessObject, citiesViewModel, mapViewModel, settingsViewModel, weatherViewModel);
        content.add(weatherView, weatherView.viewName);

//
//        CitiesView citiesView = CitiesUseCaseFactory.create(mainContentViewManagerModel, citiesViewModel, mapViewModel, getWeatherViewModel);
//        content.add(citiesView, citiesView.viewName);
//
//        MapView mapView = MapUseCaseFactory.create(mainContentViewManagerModel, mapViewModel, getWeatherViewModel, citiesViewModel);
//        content.add(mapView, mapView.viewName);
//

        SettingsView settingsView = SettingsUseCaseFactory.create(settingsViewModel, settingsDataAccessObject);
        content.add(settingsView, settingsView.viewName);
    }

    @
}
