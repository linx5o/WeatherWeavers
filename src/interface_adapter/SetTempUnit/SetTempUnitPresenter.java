package interface_adapter.SetTempUnit;

import interface_adapter.Settings.SettingsState;
import interface_adapter.Settings.SettingsViewModel;
import use_case.set_temp_unit.SetTempUnitOutputBoundary;
import use_case.set_temp_unit.SetTempUnitOutputData;

public class SetTempUnitPresenter implements SetTempUnitOutputBoundary {

    private SettingsViewModel settingsViewModel;

    public SetTempUnitPresenter(SettingsViewModel settingsViewModel) {
        this.settingsViewModel = settingsViewModel;
    }

    @Override
    public void prepareSuccessView(SetTempUnitOutputData setTempUnitOutputData) {
        SettingsState state = settingsViewModel.getState();
        state.setTempUnit(setTempUnitOutputData.isCelsius());
        settingsViewModel.setState(state);
        settingsViewModel.firePropertyChanged();
    }

}
