package interface_adapter.GetWeather;

import use_case.humidity.HumidityOutputBoundary;
import use_case.humidity.HumidityOutputData;

public class HumidityPresenter implements HumidityOutputBoundary {
    private final HumidityViewModel humidityViewModel;

    public HumidityPresenter(HumidityViewModel humidityViewModel) {
        this.humidityViewModel = humidityViewModel;
    }

    @Override
    public void prepareSuccessView(HumidityOutputData humidityOutputData) {
        HumidityState state = humidityViewModel.getState();
        state.setHumidity(humidityOutputData.getHumidity().toString());
        state.setDescriptions(humidityOutputData.getDescriptions());
        humidityViewModel.setState(state);
        humidityViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        HumidityState state = humidityViewModel.getState();
        state.setHumidity(null);
        state.setDescriptions(null);
        humidityViewModel.setState(state);
        humidityViewModel.firePropertyChanged();
    }
}
