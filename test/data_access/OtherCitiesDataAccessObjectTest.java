package data_access;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class OtherCitiesDataAccessObjectTest {
    public static final String API_CONDITIONS = "https://api.aerisapi.com/conditions/";
    private static final String API_TOKEN = System.getenv("API_TOKEN");
    private static final String API_SECRET = System.getenv("API_SECRET");
    private LocalTime LocalTime;
    private OtherCitiesDataAccessObject otherCitiesDataAccessObject;

    private GetSettingsDataAccessObject getSettingsDataAccessObject;

    @Before
    public void setUp() {
        otherCitiesDataAccessObject = new OtherCitiesDataAccessObject();
        getSettingsDataAccessObject = new GetSettingsDataAccessObject();
        //TODO replace this time with some specific time
        LocalTime = java.time.LocalTime.now();
    }

    @Test
    public void testGetApiToken() {
        assertEquals(API_TOKEN, OtherCitiesDataAccessObject.getApiToken());
    }

    @Test
    public void testGetCityWeatherCelsius() {
        otherCitiesDataAccessObject.fetchWeatherForCities(LocalTime, getSettingsDataAccessObject.getSettings().getSavedCities(), true);
    }

    @Test
    public void testGetCityWeatherFahrenheit() {
        otherCitiesDataAccessObject.fetchWeatherForCities(LocalTime, getSettingsDataAccessObject.getSettings().getSavedCities(), false);
    }

    @Test
    public void testGetCityWeatherInvalidCity() {
        try{
            ArrayList<String> invalidCity = new ArrayList<>();
            invalidCity.add("InvalidCity");
            otherCitiesDataAccessObject.fetchWeatherForCities(LocalTime, invalidCity, true);
        } catch (Exception e) {
            assert true;
        }
    }
}
