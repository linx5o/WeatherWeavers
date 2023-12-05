package entity;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LocationTest {
    private String cityName;

    private double longitude;
    private double latitude;

    @Before
    public void setUp() {
        cityName = "Toronto";
        longitude = 51.5074;
        latitude = 0.1278;
    }

    @Test
    public void testGetCityName() {
        Location location = new Location("Toronto");
        assertEquals("Toronto", location.getCityName());
    }

    @Test
    public void testGetLatitude() {
        Location location = new Location(51.5074, 0.1278);
        assertEquals(latitude, location.getLatitude());
    }

    @Test
    public void testGetLongitude() {
        Location location = new Location(51.5074, 0.1278);
        assertEquals(longitude, location.getLongitude());
    }

    @Test
    public void testSetCityName() {
        Location location = new Location("Toronto");
        location.setCityName("London");
        assertEquals("London", location.getCityName());
    }

    @Test
    public void testSetLatitude() {
        Location location = new Location(51.5074, 0.1278);
        location.setLatitude(43.6532);
        assertEquals(43.6532, location.getLatitude());
    }

    @Test
    public void testSetLongitude() {
        Location location = new Location(51.5074, 0.1278);
        location.setLongitude(79.3832);
        assertEquals(79.3832, location.getLongitude());
    }
}
