package use_case.get_other_cities;

public interface GetOtherCitiesDataAccessInterface {
    GetOtherCitiesOutputData fetchOtherCityWeather(GetOtherCitesInputData request);
}
