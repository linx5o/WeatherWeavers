package data_access;

import entity.Settings;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class GetSettingsDataAccessObjectTest {
    private Settings settings;
    private GetSettingsDataAccessObject getSettingsDataAccessObject;

    @Before
    public void setUp() {
        getSettingsDataAccessObject = new GetSettingsDataAccessObject();
        ArrayList<String> savedCities = new ArrayList<>();
        savedCities.add("ottawa,ca");
        savedCities.add("montreal,ca");
        savedCities.add("vancouver,ca");
        savedCities.add("winnipeg,ca");
        savedCities.add("calgary,ca");
        this.settings = new Settings(true, true, true, "toronto,ca", savedCities);

    }
    @Test
    public void testGetSettings() {
        Settings settings1 = getSettingsDataAccessObject.getSettings();
        assertEquals(settings1.getCelsius(), settings.getCelsius());
        assertEquals(settings1.getDarkMode(), settings.getDarkMode());
        assertEquals(settings1.getTimeFormat(), settings.getTimeFormat());
        assertEquals(settings1.getDefaultCity(), settings.getDefaultCity());
    }
}
