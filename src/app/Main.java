package app;

import data_access.*;
import interface_adapter.*;
import interface_adapter.Cities.CitiesViewModel;
import interface_adapter.GetWeather.GetWeatherViewModel;
import interface_adapter.Hourly.HourlyViewModel;
import interface_adapter.Humidity.HumidityViewModel;
import interface_adapter.OtherCities.OtherCitiesViewModel;
import interface_adapter.GetWeatherOnMap.GetWeatherOnMapViewModel;
import interface_adapter.Settings.SettingsViewModel;
import interface_adapter.Sidebar.SidebarViewModel;
import use_case.forecast.ForecastDataAccessInterface;
import use_case.get_weather.GetWeatherDataAccessInterface;
import use_case.get_weather_on_map.GetWeatherOnMapDataAccessInterface;
import use_case.hourly.HourlyDataAccessInterface;
import use_case.humidity.HumidityDataAccessInterface;
import use_case.get_other_cities.GetOtherCitiesDataAccessInterface;
import use_case.settings_start.SettingsDataAccessInterface;
import view.ViewManager;
import view.settings.SettingsView;
import view.sidebar.SidebarView;
import view.map.MapView;
import view.weather.WeatherView;
import interface_adapter.Forecast.ForecastViewModel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Load Fonts
        ImportFont.loadAndRegisterAllFontWeights();

        //Create Container
        JFrame application = new JFrame("Weather Weavers");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        JPanel app = new JPanel(new GridBagLayout());
//
//        app.setBackground(Color.decode("#0D131D"));
//
//        GridBagConstraints c = new GridBagConstraints();
//
//        c.fill = GridBagConstraints.NONE;
//        c.anchor = GridBagConstraints.FIRST_LINE_START;
//        c.weightx = 0;
//        c.weighty = 0;
//        c.gridx = 0;
//        c.gridy = 0;
//        c.gridheight = 4;
//        c.insets = new Insets(20, 20, 0, 20);
//        RoundedPanel a = new RoundedPanel(20);
//        a.setPreferredSize(new Dimension(60, 520));
//        a.setBackground(Color.decode("#222B3A"));
//        app.add(a, c);
//
//        c.fill = GridBagConstraints.NONE;
//        c.weightx = 0;
//        c.weighty = 0;
//        c.gridx = 1;
//        c.gridy = 0;
//        c.gridwidth = 2;
//        c.insets = new Insets(20, 0, 20, 0);
//        RoundedPanel b = new RoundedPanel(20);
//        b.setPreferredSize(new Dimension(620, 40));
//        b.setBackground(Color.decode("#222B3A"));
//        app.add(b, c);
//
//        c.fill = GridBagConstraints.NONE;
//        c.weightx = 0;
//        c.weighty = 0;
//        c.gridx = 1;
//        c.gridy = 2;
//        c.gridwidth = 2;
//        c.insets = new Insets(80, 0, 0, 0);
//        JPanel mainContent = new JPanel(new GridBagLayout());
//        mainContent.setPreferredSize(new Dimension(620, 260));
//        mainContent.setBackground(Color.gray);
//        app.add(mainContent, c);
//
//        c.fill = GridBagConstraints.NONE;
//        c.weightx = 0;
//        c.weighty = 0;
//        c.gridx = 1;
//        c.gridy = 3;
//        c.insets = new Insets(360, 0, 0, 0);
//        RoundedPanel d = new RoundedPanel(20);
//        d.setPreferredSize(new Dimension(420, 180));
//        d.setBackground(Color.decode("#222B3A"));
//        app.add(d, c);
//
//        c.fill = GridBagConstraints.NONE;
//        c.weightx = 0;
//        c.weighty = 0;
//        c.gridx = 2;
//        c.gridy = 3;
//        c.insets = new Insets(360, 440, 0, 20);
//        RoundedPanel e = new RoundedPanel(20);
//        e.setPreferredSize(new Dimension(180, 180));
//        e.setBackground(Color.decode("#222B3A"));
//        app.add(e, c);
//
//        c.fill = GridBagConstraints.NONE;
//        c.weightx = 0;
//        c.weighty = 0;
//        c.gridx = 1;
//        c.gridy = 4;
//        c.gridwidth = 3;
//        c.insets = new Insets(20, 0, 20, 0);
//        RoundedPanel f = new RoundedPanel(20);
//        f.setPreferredSize(new Dimension(900, 120));
//        f.setBackground(Color.decode("#222B3A"));
//        app.add(f, c);
//
//        c.fill = GridBagConstraints.NONE;
//        c.weightx = 0;
//        c.weighty = 0;
//        c.gridx = 3;
//        c.gridy = 2;
//        c.insets = new Insets(80, 20, 0, 20);
//        RoundedPanel g = new RoundedPanel(20);
//        g.setPreferredSize(new Dimension(260, 460));
//        g.setBackground(Color.decode("#222B3A"));
//        app.add(g, c);
//
//        application.add(app);
//
//        application.pack();
//        application.setResizable(false);
//        application.setVisible(true);

        // Define ViewModels
//        SidebarViewModel sideBarViewModel = new SidebarViewModel();
//        SearchViewModel searchViewModel = new SearchViewModel();

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
        SettingsDataAccessInterface settingsDataAccessObject = new SettingsDataAccessObject();
        ChangeSettingsDataAccessObject changeSettingsDataAccessObject = new ChangeSettingsDataAccessObject();
        GetWeatherOnMapDataAccessInterface getWeatherOnMapDataAccessObject = new GetWeatherOnMapDataAccessObject();

        // Define Content View Manager
        CardLayout cardLayout = new CardLayout();
        JPanel content = new JPanel(cardLayout);

        ViewManagerModel mainContentViewManagerModel = new ViewManagerModel();
        ViewManager mainContentViewManager = new ViewManager(content, cardLayout, mainContentViewManagerModel);


        // The main application view.
        JPanel main = new JPanel(new BorderLayout());
        application.add(main);

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
        searchPlaceHolder.setBackground(Color.decode("#0D131D"));
        searchPlaceHolder.setLayout(new GridBagLayout());
        JLabel searchLabel = new JLabel("W e a t h e r     W e a v e r s");
        searchLabel.setFont(ImportFont.getFont("ExtraLight", 36));
        searchLabel.setForeground(Color.white);
        searchPlaceHolder.add(searchLabel);

        search.add(searchPlaceHolder);


        // Main Content
        mainSide.add(content, BorderLayout.CENTER);

//        WeatherView weatherView = WeatherFactory.create(mainContentViewManager, getWeatherViewModel, getWeatherDataAccessObject, getSettingsDataAccessObject, hourlyViewModel, hourlyDataAccessObject, humidityViewModel, humidityDataAccessObject, otherCitiesViewModel, otherCitiesDataAccessObject, forecastViewModel, forecastDataAccessObject, citiesViewModel, mapViewModel, settingsViewModel, weatherViewModel);
//        content.add(weatherView, weatherView.viewName);


//        CitiesView citiesView = CitiesUseCaseFactory.create(mainContentViewManagerModel, citiesViewModel, mapViewModel, getWeatherViewModel);
//        content.add(citiesView, citiesView.viewName);
//
        MapView mapView = MapUseCaseFactory.create(mainContentViewManagerModel, mapViewModel, getWeatherOnMapDataAccessObject, getSettingsDataAccessObject);
        content.add(mapView, mapView.viewName);


        SettingsView settingsView = SettingsUseCaseFactory.create(settingsViewModel, settingsDataAccessObject, changeSettingsDataAccessObject, changeSettingsDataAccessObject, changeSettingsDataAccessObject, changeSettingsDataAccessObject, changeSettingsDataAccessObject);
        content.add(settingsView, settingsView.viewName);

//        mainContentViewManagerModel.setActiveView(weatherView.viewName);
//        mainContentViewManagerModel.firePropertyChanged();

//        JPanel contentPlaceHolder = new JPanel();
//        contentPlaceHolder.setPreferredSize(new Dimension(920, 620));
//        contentPlaceHolder.setBackground(Color.green);
//        content.add(contentPlaceHolder);

        application.pack();
        application.setResizable(false);
        application.setVisible(true);
    }
}
