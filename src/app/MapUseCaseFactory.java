package app;

import interface_adapter.GetWeatherOnMap.GetWeatherOnMapController;
import interface_adapter.GetWeatherOnMap.GetWeatherOnMapPresenter;
import interface_adapter.GetWeatherOnMap.GetWeatherOnMapViewModel;
import interface_adapter.ViewManagerModel;
import use_case.get_weather_on_map.*;
import view.map.MapView;

public class MapUseCaseFactory {
    private MapUseCaseFactory() {
    }

    public static MapView create(ViewManagerModel viewManagerModel, GetWeatherOnMapViewModel mapViewModel, GetWeatherOnMapDataAccessInterface mapDataAccessObject, GetWeatherOnMapSettingDataAccessInterface mapSettingDataAccessObject) {
        try {
            GetWeatherOnMapController mapController = createGetWeatherOnMapUseCase(mapViewModel, mapDataAccessObject, mapSettingDataAccessObject);
            return new MapView(mapController, mapViewModel);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    private static GetWeatherOnMapController createGetWeatherOnMapUseCase(GetWeatherOnMapViewModel mapViewModel, GetWeatherOnMapDataAccessInterface mapDataAccessObject, GetWeatherOnMapSettingDataAccessInterface mapSettingDataAccessObject) {
        GetWeatherOnMapOutputBoundary mapOutputBoundary = new GetWeatherOnMapPresenter(mapViewModel);
        GetWeatherOnMapInputBoundary mapInteractor = new GetWeatherOnMapInteractor(mapDataAccessObject, mapOutputBoundary, mapSettingDataAccessObject);
        return new GetWeatherOnMapController(mapInteractor);
    }
}
