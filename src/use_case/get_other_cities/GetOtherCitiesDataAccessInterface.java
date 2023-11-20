package use_case.get_other_cities;

import java.time.LocalTime;
import java.util.ArrayList;
import entity.Weather;

public interface GetOtherCitiesDataAccessInterface {
    ArrayList<Weather> fetchWeatherForCities(LocalTime localTime, ArrayList<String> savedCities, Boolean celsius);
}
