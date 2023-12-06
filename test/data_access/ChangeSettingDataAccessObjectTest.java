package data_access;

import entity.Settings;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ChangeSettingDataAccessObjectTest {
    private static final String API_TOKEN = System.getenv("API_TOKEN");
    private static final String API_SECRET = System.getenv("API_SECRET");
    ChangeSettingsDataAccessObject changeSettingsDataAccessObject;

    @Before
    public void setUp() {
        try {
            changeSettingsDataAccessObject = new ChangeSettingsDataAccessObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testEraseCity() {
        try {
            changeSettingsDataAccessObject.eraseCity("ottawa,ca");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testAddCity() {
        try {
            changeSettingsDataAccessObject.addCity("ottawa,ca");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testToggleTempUnit() {
        try {
            changeSettingsDataAccessObject.toggleTempUnit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
