package data_access;

import entity.Weather;
import use_case.get_other_cities.GetOtherCitiesDataAccessInterface;

import java.time.LocalTime;
import java.util.ArrayList;

public class OtherCitiesDataAccessObject implements GetOtherCitiesDataAccessInterface {
    @Override
    public ArrayList<Weather> fetchWeatherForCities(LocalTime localTime, ArrayList<String> savedCities, Boolean celsius) {
        return null;
    }
}
