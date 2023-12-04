package data_access;

import org.junit.Before;
import org.junit.Test;
import use_case.get_weather_on_map.GetWeatherOnMapSettingDataAccessInterface;

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
        assert GetWeatherOnMapDataAccessObject.getCoordinates("Toronto") == ("43.6532,79.3832").split(",");
    }
}
