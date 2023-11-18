package app;

import interface_adapter.GetWeather.OtherCitiesViewModel;
import use_case.get_weather.GetSettingsDataAccessInterface;
import use_case.other_cities.OtherCitiesDataAccessInterface;
import use_case.other_cities.OtherCitiesListDataAccessInterface;
import view.Weather.OtherCitiesView;

public class OtherCitiesUseCaseFactory {
    private OtherCitiesUseCaseFactory() {}

    public static OtherCitiesView create(OtherCitiesViewModel otherCitiesViewModel, OtherCitiesDataAccessInterface otherCitiesDataAccessObject, OtherCitiesListDataAccessInterface otherCitiesListDataAccessObject, GetSettingsDataAccessInterface getSettingsDataAccessObject) {
        try {
            OtherCitiesController otherCitiesController = createOtherCitiesUseCase(otherCitiesViewModel, otherCitiesDataAccessObject, otherCitiesListDataAccessObject, getSettingsDataAccessObject);
            return new OtherCitiesView(otherCitiesController, otherCitiesViewModel);
        } catch (Exception e) {
            // TODO - better error handling
        }

        return null;
    }

    private static OtherCitiesController createOtherCitiesUseCase(OtherCitiesViewModel otherCitiesViewModel, OtherCitiesDataAccessInterface otherCitiesDataAccessObject, OtherCitiesListDataAccessInterface otherCitiesListDataAccessObject, GetSettingsDataAccessInterface getSettingsDataAccessObject) {
        OtherCitiesOutputBoundary otherCitiesOutputBoundary = new OtherCitiesPresenter(otherCitiesViewModel);

        OtherCitiesInputBoundary otherCitiesInteractor = new OtherCitiesInteractor(otherCitiesDataAccessObject, otherCitiesListDataAccessObject, getSettingsDataAccessObject, otherCitiesOutputBoundary);

        return new OtherCitiesController(otherCitiesInteractor);
    }
}
