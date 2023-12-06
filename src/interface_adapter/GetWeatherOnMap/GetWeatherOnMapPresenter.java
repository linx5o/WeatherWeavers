package interface_adapter.GetWeatherOnMap;

import use_case.get_weather_on_map.GetWeatherOnMapOutputBoundary;
import use_case.get_weather_on_map.GetWeatherOnMapOutputData;

public class GetWeatherOnMapPresenter implements GetWeatherOnMapOutputBoundary {
    private final GetWeatherOnMapViewModel getWeatherOnMapViewModel;

    public GetWeatherOnMapPresenter(GetWeatherOnMapViewModel getWeatherOnMapViewModel) {
        this.getWeatherOnMapViewModel = getWeatherOnMapViewModel;
    }

    @Override
    public void prepareWeatherPage(GetWeatherOnMapOutputData getWeatherOnMapOutputData) {
        GetWeatherOnMapState state = getWeatherOnMapViewModel.getState();
        state.setMapPanel(getWeatherOnMapOutputData.getPanel());
        getWeatherOnMapViewModel.setState(state);
        getWeatherOnMapViewModel.firePropertyChanged();
    }
}
