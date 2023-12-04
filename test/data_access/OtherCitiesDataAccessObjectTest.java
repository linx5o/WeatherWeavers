package data_access;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

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
        assertEquals(null, otherCitiesDataAccessObject.fetchWeatherForCities(LocalTime, getSettingsDataAccessObject.getSettings().getSavedCities(), true));
        //TODO replace the expected value with the actual value that should get from the API
    }

    @Test
    public void testGetCityWeatherFahrenheit() {
        assertEquals(null, otherCitiesDataAccessObject.fetchWeatherForCities(LocalTime, getSettingsDataAccessObject.getSettings().getSavedCities(), false));
        //TODO replace the expected value with the actual value that should get from the API
    }
}
