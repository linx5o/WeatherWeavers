package app;

import interface_adapter.GetWeather.OtherCitiesController;
import interface_adapter.GetWeather.OtherCitiesPresenter;
import interface_adapter.GetWeather.OtherCitiesViewModel;
import use_case.get_other_cities.*;
import view.weather.OtherCitiesView;

public class OtherCitiesUseCaseFactory {
    private OtherCitiesUseCaseFactory() {}

    public static OtherCitiesView create(OtherCitiesViewModel otherCitiesViewModel, GetOtherCitiesDataAccessInterface otherCitiesDataAccessObject, OtherCitiesSettingsDataAccessInterface getSettingsDataAccessObject) {
        try {
            OtherCitiesController otherCitiesController = createOtherCitiesUseCase(otherCitiesViewModel, otherCitiesDataAccessObject, getSettingsDataAccessObject);
            return new OtherCitiesView(otherCitiesController, otherCitiesViewModel);
        } catch (Exception e) {
            // TODO - better error handling
        }

        return null;
    }

    private static OtherCitiesController createOtherCitiesUseCase(OtherCitiesViewModel otherCitiesViewModel, GetOtherCitiesDataAccessInterface otherCitiesDataAccessObject, OtherCitiesSettingsDataAccessInterface getSettingsDataAccessObject) {
        GetOtherCitiesOutputBoundary otherCitiesOutputBoundary = new OtherCitiesPresenter(otherCitiesViewModel);

        GetOtherCitiesInputBoundary otherCitiesInteractor = new GetOtherCitiesInteractor(getSettingsDataAccessObject, otherCitiesDataAccessObject, otherCitiesOutputBoundary);

        return new OtherCitiesController(otherCitiesInteractor);
    }
}
