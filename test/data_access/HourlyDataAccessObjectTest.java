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
        LocalTime = java.time.LocalTime.now();
    }

    @Test
    public void testGetApiToken() {
        assertEquals(API_TOKEN, HourlyDataAccessObject.getApiToken());
    }

    @Test
    public void testGetHours() {
        hourlyDataAccessObject.getHours("toronto, ca", LocalTime);
    }

    @Test
    public void testGetTempsCelsius() {
        hourlyDataAccessObject.getTemps("toronto, ca", LocalTime, true);
    }

    @Test
    public void testGetTempsFahrenheit() {
        hourlyDataAccessObject.getTemps("toronto, ca", LocalTime, false);
    }

    @Test
    public void testGetTempsInvalidCity() {
        try{
            hourlyDataAccessObject.getTemps("InvalidCity", LocalTime, true);
        } catch (Exception e) {
            assert true;
        }
    }
}
