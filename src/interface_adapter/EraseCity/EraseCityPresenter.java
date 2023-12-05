package interface_adapter.EraseCity;

import interface_adapter.Settings.SettingsState;
import interface_adapter.Settings.SettingsViewModel;
import use_case.erase_city.EraseCityOutputBoundary;
import use_case.erase_city.EraseCityOutputData;

public class EraseCityPresenter implements EraseCityOutputBoundary {
    private SettingsViewModel viewModel;

    public EraseCityPresenter(SettingsViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(EraseCityOutputData outputData, String message) {
        SettingsState state = viewModel.getState();
        state.addListCity(outputData.getCity());
        state.setEraseCityCity("");
        state.setEraseCityCountry("");
        state.setEraseCityMessage(message);
        viewModel.setState(state);
        viewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String message) {
        SettingsState state = viewModel.getState();
        state.setEraseCityMessage(message);
        state.setEraseCityCity("");
        state.setEraseCityCountry("");
        viewModel.setState(state);
        viewModel.firePropertyChanged();
    }
}
