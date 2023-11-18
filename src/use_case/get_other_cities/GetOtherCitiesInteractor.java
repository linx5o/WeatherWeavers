package use_case.get_other_cities;

public class GetOtherCitiesInteractor implements GetOtherCitiesInputBoundary {
    private final GetOtherCitiesDataAccessInterface dataAccess;
    private final GetOtherCitiesOutputBoundary outputBoundary;

    public GetOtherCitiesInteractor(
            GetOtherCitiesDataAccessInterface dataAccess,
            GetOtherCitiesOutputBoundary outputBoundary
    ) {
        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void getOtherCityWeather(GetOtherCitesInputData inputData) {
        GetOtherCitiesOutputData response = dataAccess.fetchOtherCityWeather(inputData);
        outputBoundary.presentOtherCityWeather(response);
    }
}
