package data_access;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ForecastDataAccessObjectTest {
    public static final String API_FORECAST = "https://api.aerisapi.com/forecast/";

    public static final String API_TOKEN = System.getenv("API_TOKEN");
    public static final String API_SECRET = System.getenv("API_SECRET");

    public ForecastDataAccessObject forecastDataAccessObject;

    public void setUp() {
        this.forecastDataAccessObject = new ForecastDataAccessObject();
    }

    @Test
    public void testGetApiToken() {
        assertEquals(API_TOKEN, ForecastDataAccessObject.getApiToken());
    }

    @Test
    public void testGetForecastCelsius() {
        assertEquals(0, forecastDataAccessObject.getForecast("Toronto", 1, true).size());
        //TODO replace the expected value with the actual value that should get from the API
    }

    @Test
    public void testGetForecastFahrenheit() {
        assertEquals(0, forecastDataAccessObject.getForecast("Toronto", 1, false).size());
        //TODO replace the expected value with the actual value that should get from the API
    }

    @Test
    public void testGetForecastInvalidCity() {
        assertEquals(0, forecastDataAccessObject.getForecast("InvalidCity", 1, true).size());
        //TODO replace the expected value with the actual value that should get from the API
    }

    @Test
    public void testGetForecastInvalidDays() {
        assertEquals(0, forecastDataAccessObject.getForecast("Toronto", -1, true).size());
        //TODO replace the expected value with the actual value that should get from the API
    }
}