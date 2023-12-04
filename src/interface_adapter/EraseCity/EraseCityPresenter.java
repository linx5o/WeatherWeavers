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
        state.setListCityCity("");
        state.setListCityCountry("");
        state.setListCityMessage(message);
        viewModel.setState(state);
        viewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String message) {
        SettingsState state = viewModel.getState();
        state.setListCityMessage(message);
        state.setListCityCity("");
        state.setListCityCountry("");
        viewModel.setState(state);
        viewModel.firePropertyChanged();
    }
}
