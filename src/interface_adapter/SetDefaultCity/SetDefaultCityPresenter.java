package interface_adapter.SetDefaultCity;

import interface_adapter.Settings.SettingsState;
import interface_adapter.Settings.SettingsViewModel;
import use_case.set_default_city.SetDefaultCityOutputBoundary;
import use_case.set_default_city.SetDefaultCityOutputData;

public class SetDefaultCityPresenter implements SetDefaultCityOutputBoundary {
    private SettingsViewModel settingsViewModel;

    public SetDefaultCityPresenter(SettingsViewModel settingsViewModel) {
        this.settingsViewModel = settingsViewModel;
    }

    @Override
    public void prepareSuccessView(SetDefaultCityOutputData setDefaultCityOutputData) {
        SettingsState state = settingsViewModel.getState();
        state.setDefaultCity(setDefaultCityOutputData.getCityName());
        String city = setDefaultCityOutputData.getCityName().split(",")[0];
        city = city.substring(0, 1).toUpperCase() + city.substring(1);
        state.setDefaultCityMessage("Current default city is " + city);
        state.setDefaultCityCity("");
        state.setDefaultCityCountry("");
        settingsViewModel.setState(state);
        settingsViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        SettingsState state = settingsViewModel.getState();
        state.setDefaultCityMessage(error);
        state.setDefaultCityCity("");
        state.setDefaultCityCountry("");
        settingsViewModel.setState(state);
        settingsViewModel.firePropertyChanged();
    }

}
