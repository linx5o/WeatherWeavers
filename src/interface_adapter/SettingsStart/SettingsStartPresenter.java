package interface_adapter.SettingsStart;

import interface_adapter.Settings.SettingsState;
import interface_adapter.Settings.SettingsViewModel;
import use_case.settings_start.SettingsStartOutputBoundary;
import use_case.settings_start.SettingsStartOutputData;

public class SettingsStartPresenter implements SettingsStartOutputBoundary {
    private SettingsViewModel viewModel;

    public SettingsStartPresenter(SettingsViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(SettingsStartOutputData outputData) {
        SettingsState state = new SettingsState();
        state.addListCity(outputData.getCities());
        state.setDefaultCity(outputData.getDefaultCity());
        state.setTempUnit(outputData.getCelsius());
        state.setTimeFormat(outputData.getTime24());
        viewModel.setState(state);
        viewModel.firePropertyChanged();
    }

}
