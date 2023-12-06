package use_case.settings_start;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import entity.Settings;

public class SettingsStartInteractorTest {

    private SettingsStartOutputBoundary presenter;
    private SettingsDataAccessInterface settingsDataAccessObject;
    private Settings settings;

    @Before
    public void setUp() {
        presenter = new SettingsStartOutputBoundary() {
            @Override
            public void prepareSuccessView(SettingsStartOutputData outputData) {
                settings = new Settings(outputData.getCelsius(), true, outputData.getTime24(), outputData.getDefaultCity(), outputData.getCities());
            }
        };

        settingsDataAccessObject = new SettingsDataAccessInterface() {
            @Override
            public Settings getSettings() {
                ArrayList<String> savedCities = new ArrayList<>();
                return new Settings(true, true, true, "", savedCities);
            }
        };
    }

    @Test
    public void testExecute() {
        SettingsStartInteractor interactor = new SettingsStartInteractor(presenter, settingsDataAccessObject);
        interactor.execute();
        assert(settings.getCelsius());
        assert(settings.getTimeFormat());
        assert(settings.getSavedCities().isEmpty());
        assert(settings.getDefaultCity().equals(""));
    }

}
