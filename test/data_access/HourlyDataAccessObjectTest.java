package data_access;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

import static junit.framework.TestCase.assertEquals;

public class HourlyDataAccessObjectTest {
    public static final String API_CONDITIONS = "https://api.aerisapi.com/conditions/";
    // load API_TOKEN from env variable.
    private static final String API_TOKEN = System.getenv("API_TOKEN");
    private static final String API_SECRET = System.getenv("API_SECRET");
    private HourlyDataAccessObject hourlyDataAccessObject;
    private java.time.LocalTime LocalTime;

    @Before
    public void setUp() {
        hourlyDataAccessObject = new HourlyDataAccessObject();
        //TODO replace this time with some specific time
        LocalTime = java.time.LocalTime.now();
    }

    @Test
    public void testGetApiToken() {
        assertEquals(API_TOKEN, HourlyDataAccessObject.getApiToken());
    }

    @Test
    public void testGetHours() {
        assertEquals(null, hourlyDataAccessObject.getHours("Toronto", LocalTime));
        //TODO replace the expected value with the actual value that should get from the API
    }

    @Test
    public void testGetTempsCelsius() {
        assertEquals(null, hourlyDataAccessObject.getTemps("Toronto", LocalTime, true));
        //TODO replace the expected value with the actual value that should get from the API
    }

    @Test
    public void testGetTempsFahrenheit() {
        assertEquals(null, hourlyDataAccessObject.getTemps("Toronto", LocalTime, false));
        //TODO replace the expected value with the actual value that should get from the API
    }
}
