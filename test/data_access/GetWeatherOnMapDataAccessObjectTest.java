package data_access;

import org.junit.Before;
import org.junit.Test;
import use_case.get_weather_on_map.GetWeatherOnMapSettingDataAccessInterface;

import java.util.Arrays;
import java.util.Objects;

public class GetWeatherOnMapDataAccessObjectTest {
    private String pageURL;
    private GetWeatherOnMapSettingDataAccessInterface GetSettingsDataAccessObject;
    private GetWeatherOnMapDataAccessObject getWeatherOnMapDataAccessObject;

    @Before
    public void setUp() {
        this.pageURL = "src/data_access/mapPage.html";
        GetSettingsDataAccessObject = new GetSettingsDataAccessObject();
        getWeatherOnMapDataAccessObject = new GetWeatherOnMapDataAccessObject();
    }

    @Test
    public void testGetWeatherOnMap() {
        //TODO Can't test this method because it returns a JPanel
    }

    @Test
    public void testGetCoordinates() {
        String[] coordinates = GetWeatherOnMapDataAccessObject.getCoordinates("Toronto");
        assert GetWeatherOnMapDataAccessObject.getCoordinates("Toronto") != null;
        if (coordinates != null) {
            assert Objects.equals(coordinates[0], "43.6534817");
        }
        if (coordinates != null) {
            assert Objects.equals(coordinates[1], "-79.3839347");
        }
    }

    @Test
    public void testGetCoordinatesInvalidCity() {
        String[] coordinates = GetWeatherOnMapDataAccessObject.getCoordinates("InvalidCity");
        assert coordinates == null;
    }

    @Test
    public void testGetCoordinatesEmptyCity() {
        String[] coordinates = GetWeatherOnMapDataAccessObject.getCoordinates("");
        assert coordinates == null;
    }


}
