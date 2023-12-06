package interface_adapter.SetTimeFormat;

import interface_adapter.Settings.SettingsState;
import interface_adapter.Settings.SettingsViewModel;
import use_case.set_time_format.SetTimeFormatOutputBoundary;
import use_case.set_time_format.SetTimeFormatOutputData;

public class SetTimeFormatPresenter implements SetTimeFormatOutputBoundary {
    private SettingsViewModel settingsViewModel;

    public SetTimeFormatPresenter(SettingsViewModel settingsViewModel) {
        this.settingsViewModel = settingsViewModel;
    }

    @Override
    public void prepareSuccessView(SetTimeFormatOutputData setTimeFormatOutputData) {
        SettingsState state = settingsViewModel.getState();
        state.setTimeFormat(setTimeFormatOutputData.getIs24HourFormat());
        settingsViewModel.setState(state);
        settingsViewModel.firePropertyChanged();
    }
}
