package entity;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;

public class SettingTest {
    private Boolean celsius;
    private Boolean darkMode; // True for dark mode, False for light mode
    private Boolean timeFormat; // True for 24-hour format, False for 12-hour format
    private String defaultCity;
    private ArrayList<String> savedCities;

    public void setUp() {
        celsius = true;
        darkMode = true;
        timeFormat = true;
        defaultCity = "Toronto";
        savedCities = new ArrayList<String>();
        savedCities.add("Toronto");
        savedCities.add("Vancouver");
        savedCities.add("Montreal");
        savedCities.add("Ottawa");
    }

    @Test
    public void testGetCelsius() {
        Settings settings = new Settings(true, true, true, "Toronto", savedCities);
        assertEquals(Optional.of(true), settings.getCelsius());
    }

    @Test
    public void testGetDarkMode() {
        Settings settings = new Settings(true, true, true, "Toronto", savedCities);
        assertEquals(Optional.of(true), settings.getDarkMode());
    }

    @Test
    public void testGetTimeFormat() {
        Settings settings = new Settings(true, true, true, "Toronto", savedCities);
        assertEquals(Optional.of(true), settings.getTimeFormat());
    }

    @Test
    public void testGetDefaultCity() {
        Settings settings = new Settings(true, true, true, "Toronto", savedCities);
        assertEquals(Optional.of("Toronto"), settings.getDefaultCity());
    }

    @Test
    public void testGetSavedCities() {
        Settings settings = new Settings(true, true, true, "Toronto", savedCities);
        assertEquals(Optional.of(savedCities), settings.getSavedCities());
    }

    @Test
    public void testSetCelsius() {
        Settings settings = new Settings(true, true, true, "Toronto", savedCities);
        settings.setCelsius(false);
        assertEquals(Optional.of(false), settings.getCelsius());
    }

    @Test
    public void testSetDarkMode() {
        Settings settings = new Settings(true, true, true, "Toronto", savedCities);
        settings.setDarkMode(false);
        assertEquals(Optional.of(false), settings.getDarkMode());
    }

    @Test
    public void testSetTimeFormat() {
        Settings settings = new Settings(true, true, true, "Toronto", savedCities);
        settings.setTimeFormat(false);
        assertEquals(Optional.of(false), settings.getTimeFormat());
    }

    @Test
    public void testSetDefaultCity() {
        Settings settings = new Settings(true, true, true, "Toronto", savedCities);
        settings.setDefaultCity("Vancouver");
        assertEquals(Optional.of("Vancouver"), settings.getDefaultCity());
    }

    @Test
    public void testAddSavedCities() {
        Settings settings = new Settings(true, true, true, "Toronto", savedCities);
        settings.addSavedCities("Calgary");
        assertEquals(Optional.of("Calgary"), settings.getSavedCities().get(4));
    }

    @Test
    public void testRemoveSavedCities() {
        Settings settings = new Settings(true, true, true, "Toronto", savedCities);
        settings.removeSavedCities("Toronto");
        assertEquals(Optional.of("Vancouver"), settings.getSavedCities().get(0));
    }

    @Test
    public void testEmptySavedCities() {
        Settings settings = new Settings(true, true, true, "Toronto", savedCities);
        settings.emptySavedCities();
        assertEquals(Optional.of(new ArrayList<String>()), settings.getSavedCities());
    }
}
