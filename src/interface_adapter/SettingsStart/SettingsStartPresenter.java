package interface_adapter.SettingsStart;

import interface_adapter.Settings.SettingsState;
import interface_adapter.Settings.SettingsViewModel;
import use_case.settings_start.SettingsStartOutputBoundary;
import use_case.settings_start.SettingsStartOutputData;

import java.util.Objects;

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
        if (!Objects.equals(outputData.getDefaultCity(), "")) {
            state.setDefaultCityMessage("Current default city: " + outputData.getDefaultCity().split(",")[0].substring(0, 1).toUpperCase() + outputData.getDefaultCity().split(",")[0].substring(1) + ", " + outputData.getDefaultCity().split(",")[1].toUpperCase());
        } else {
            state.setDefaultCityMessage("No default city set");
        }
        viewModel.setState(state);
        viewModel.firePropertyChanged();
    }

}
