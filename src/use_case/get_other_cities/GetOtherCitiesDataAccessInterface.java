package data_access;

import use_case.get_other_cities.GetOtherCitiesOutputData;

import java.util.List;

public interface GetOtherCitiesDataAccessInterface {
    GetOtherCitiesOutputData getWeatherForOtherCities(long timestamp, List<String> cityNames);
}
