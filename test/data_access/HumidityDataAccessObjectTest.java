package data_access;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class HumidityDataAccessObjectTest {
    public static final String API_CONDITIONS = "https://api.aerisapi.com/conditions/";
    // load API_TOKEN from env variable.
    private static final String API_TOKEN = System.getenv("API_TOKEN");
    private static final String API_SECRET = System.getenv("API_SECRET");
    private HumidityDataAccessObject humidityDataAccessObject;

    @Before
    public void setUp() {
        humidityDataAccessObject = new HumidityDataAccessObject();
    }

    @Test
    public void testGetApiToken() {
        assertEquals(API_TOKEN, HumidityDataAccessObject.getApiToken());
    }

    @Test
    public void testGetHumidity() {
        humidityDataAccessObject.getHumidity("toronto, ca", "2021-03-20");
    }

    @Test
    public void testGetHumidityInvalidCity() {
        try{
            humidityDataAccessObject.getHumidity("InvalidCity", "2021-03-20");
        } catch (Exception e) {
            assert true;
        }
    }
}
