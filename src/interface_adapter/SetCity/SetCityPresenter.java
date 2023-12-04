package interface_adapter.SetCity;

import interface_adapter.Settings.SettingsState;
import interface_adapter.Settings.SettingsViewModel;
import use_case.set_city.SetCityOutputBoundary;
import use_case.set_city.SetCityOutputData;

public class SetCityPresenter implements SetCityOutputBoundary {
    private final SettingsViewModel settingsViewModel;

    public SetCityPresenter(SettingsViewModel settingsViewModel) {
        this.settingsViewModel = settingsViewModel;
    }

    @Override
    public void prepareSuccessView(SetCityOutputData setCityOutputData, String success) {
        SettingsState state = settingsViewModel.getState();
        state.addListCity(setCityOutputData.getCity());
        state.setListCityMessage(success);
        settingsViewModel.setState(state);
        settingsViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        SettingsState state = settingsViewModel.getState();
        state.setListCityMessage(error);
        settingsViewModel.setState(state);
        settingsViewModel.firePropertyChanged();
    }

}
