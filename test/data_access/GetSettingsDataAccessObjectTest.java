package data_access;

import entity.Settings;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GetSettingsDataAccessObjectTest {
    private Settings settings;
    private GetSettingsDataAccessObject getSettingsDataAccessObject;

    @Before
    public void setUp() {
        getSettingsDataAccessObject = new GetSettingsDataAccessObject();
        this.settings.setCelsius(true);
        this.settings.setDarkMode(false);
        this.settings.setTimeFormat(true);
        this.settings.setDefaultCity("ottawa,ca");
        this.settings.addSavedCities("winnipeg,ca");
        this.settings.addSavedCities("montreal,ca");
        this.settings.addSavedCities("vancouver,ca");
        this.settings.addSavedCities("toronto,ca");
        this.settings.addSavedCities("calgary,ca");
    }
    @Test
    public void testGetSettings() {
        Settings settings1 = getSettingsDataAccessObject.getSettings();
        assertEquals(settings1.getCelsius(), settings.getCelsius());
        assertEquals(settings1.getDarkMode(), settings.getDarkMode());
        assertEquals(settings1.getTimeFormat(), settings.getTimeFormat());
        assertEquals(settings1.getDefaultCity(), settings.getDefaultCity());
        assertEquals(settings1.getSavedCities(), settings.getSavedCities());
    }
}
