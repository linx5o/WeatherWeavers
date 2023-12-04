package interface_adapter.ChangeMainContent;

import interface_adapter.Cities.CitiesViewModel;
import interface_adapter.Forecast.ForecastViewModel;
import interface_adapter.GetWeather.GetWeatherViewModel;
import interface_adapter.GetWeatherOnMap.GetWeatherOnMapViewModel;
import interface_adapter.Hourly.HourlyViewModel;
import interface_adapter.Humidity.HumidityViewModel;
import interface_adapter.OtherCities.OtherCitiesViewModel;
import interface_adapter.Settings.SettingsViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.WeatherViewModel;
import use_case.change_main_content.ChangeMainContentOutputBoundary;
import use_case.change_main_content.ChangeMainContentOutputData;

public class ChangeMainContentPresenter implements ChangeMainContentOutputBoundary{

    final ViewManagerModel viewManagerModel;
    final WeatherViewModel weatherViewModel;
    final GetWeatherViewModel getWeatherViewModel;
    final HourlyViewModel hourlyViewModel;
    final ForecastViewModel forecastViewModel;
    final HumidityViewModel humidityViewModel;
    final OtherCitiesViewModel otherCitiesViewModel;
    final SettingsViewModel settingsViewModel;
    final GetWeatherOnMapViewModel getWeatherOnMapViewModel;
    final CitiesViewModel citiesViewModel;

    public ChangeMainContentPresenter(ViewManagerModel viewManagerModel, WeatherViewModel weatherViewModel, GetWeatherViewModel getWeatherViewModel, HourlyViewModel hourlyViewModel, ForecastViewModel forecastViewModel, HumidityViewModel humidityViewModel, OtherCitiesViewModel otherCitiesViewModel, SettingsViewModel settingsViewModel, GetWeatherOnMapViewModel getWeatherOnMapViewModel, CitiesViewModel citiesViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.weatherViewModel = weatherViewModel;
        this.getWeatherViewModel = getWeatherViewModel;
        this.hourlyViewModel = hourlyViewModel;
        this.forecastViewModel = forecastViewModel;
        this.humidityViewModel = humidityViewModel;
        this.otherCitiesViewModel = otherCitiesViewModel;
        this.settingsViewModel = settingsViewModel;
        this.getWeatherOnMapViewModel = getWeatherOnMapViewModel;
        this.citiesViewModel = citiesViewModel;
    }

    @Override
    public void prepareSuccessView(ChangeMainContentOutputData outputData) {
        if (outputData.getViewName().equals(weatherViewModel.getViewName())) {
            getWeatherViewModel.firePropertyChanged();
            humidityViewModel.firePropertyChanged();
            hourlyViewModel.firePropertyChanged();
            forecastViewModel.firePropertyChanged();
            otherCitiesViewModel.firePropertyChanged();
            viewManagerModel.setActiveView(weatherViewModel.getViewName());
            viewManagerModel.firePropertyChanged();
        } else if (outputData.getViewName().equals(getWeatherOnMapViewModel.getViewName())) {
            getWeatherOnMapViewModel.firePropertyChanged();
            viewManagerModel.setActiveView(getWeatherOnMapViewModel.getViewName());
            viewManagerModel.firePropertyChanged();
        } else if (outputData.getViewName().equals(citiesViewModel.getViewName())) {
            citiesViewModel.firePropertyChanged();
            viewManagerModel.setActiveView(citiesViewModel.getViewName());
            viewManagerModel.firePropertyChanged();
        } else if (outputData.getViewName().equals(settingsViewModel.getViewName())) {
            settingsViewModel.firePropertyChanged();
            viewManagerModel.setActiveView(settingsViewModel.getViewName());
            viewManagerModel.firePropertyChanged();
        }
    }
}
