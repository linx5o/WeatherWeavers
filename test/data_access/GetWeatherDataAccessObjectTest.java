package data_access;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GetWeatherDataAccessObjectTest {
    private static final String API_FORECAST = "https://api.aerisapi.com/forecast/";
    private static final String API_CONDITIONS = "https://api.aerisapi.com/conditions/";
    // load API_TOKEN from env variable.
    private static final String API_TOKEN = System.getenv("API_TOKEN");
    private static final String API_SECRET = System.getenv("API_SECRET");

    private GetWeatherDataAccessObject getWeatherDataAccessObject;

    @Before
    public void setUp() {
        getWeatherDataAccessObject = new GetWeatherDataAccessObject();
    }

    @Test
    public void testGetApiToken() {
        assertEquals(API_TOKEN, GetWeatherDataAccessObject.getApiToken());
    }

    @Test
    public void testGetCityWeather() {
        assertEquals(null, getWeatherDataAccessObject.getCityWeather("Toronto", "2021-03-20", true));
        //TODO replace the expected value with the actual value that should get from the API
    }

}
