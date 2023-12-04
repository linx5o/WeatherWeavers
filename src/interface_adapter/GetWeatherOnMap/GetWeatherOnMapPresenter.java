package interface_adapter.GetWeatherOnMap;

import use_case.get_weather_on_map.GetWeatherOnMapOutputData;

public class GetWeatherOnMapPresenter {
    private final GetWeatherOnMapViewModel getWeatherOnMapViewModel;

    public GetWeatherOnMapPresenter(GetWeatherOnMapViewModel getWeatherOnMapViewModel) {
        this.getWeatherOnMapViewModel = getWeatherOnMapViewModel;
    }

    public void prepareMap(GetWeatherOnMapOutputData getWeatherOnMapOutputData){
        GetWeatherOnMapState state = getWeatherOnMapViewModel.getState();
        state.setMapPanel(getWeatherOnMapOutputData.getPanel());

        getWeatherOnMapViewModel.firePropertyChanged();
    }
}
