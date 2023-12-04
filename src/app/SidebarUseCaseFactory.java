package app;

import interface_adapter.ChangeMainContent.ChangeMainContentController;
import interface_adapter.ChangeMainContent.ChangeMainContentPresenter;
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
import use_case.change_main_content.ChangeMainContentInputBoundary;
import use_case.change_main_content.ChangeMainContentInteractor;
import use_case.change_main_content.ChangeMainContentOutputBoundary;
import use_case.change_unit.ChangeUnitOutputBoundary;
import view.sidebar.SidebarView;

public class SidebarUseCaseFactory {
    private SidebarUseCaseFactory() {}

    public static SidebarView create(SidebarViewModel sidebarViewModel, GetWeatherViewModel getWeatherViewModel, CitiesViewModel citiesViewModel, GetWeatherOnMapViewModel mapViewModel, SettingsViewModel settingsViewModel, ViewManagerModel viewManagerModel, WeatherViewModel weatherViewmodel, HumidityViewModel humidityViewModel, HourlyViewModel hourlyViewModel, ForecastViewModel forecastViewModel, OtherCitiesViewModel otherCitiesViewModel) {
        ChangeMainContentController controller = createChangeMainContentController(viewManagerModel, weatherViewmodel, getWeatherViewModel, hourlyViewModel, forecastViewModel, humidityViewModel, otherCitiesViewModel, settingsViewModel, mapViewModel, citiesViewModel);
        return new SidebarView(controller);
    }

    private static ChangeMainContentController createChangeMainContentController(ViewManagerModel viewManagerModel, WeatherViewModel weatherViewModel, GetWeatherViewModel getWeatherViewModel, HourlyViewModel hourlyViewModel, ForecastViewModel forecastViewModel, HumidityViewModel humidityViewModel, OtherCitiesViewModel otherCitiesViewModel, SettingsViewModel settingsViewModel, GetWeatherOnMapViewModel getWeatherOnMapViewModel, CitiesViewModel citiesViewModel) {
        ChangeMainContentOutputBoundary changeMainContentOutputBoundary = new ChangeMainContentPresenter(viewManagerModel, weatherViewModel, getWeatherViewModel, hourlyViewModel, forecastViewModel, humidityViewModel, otherCitiesViewModel, settingsViewModel, getWeatherOnMapViewModel, citiesViewModel);

        ChangeMainContentInputBoundary changeMainContentInteractor = new ChangeMainContentInteractor(changeMainContentOutputBoundary);

        return new ChangeMainContentController(changeMainContentInteractor);
    }
}
