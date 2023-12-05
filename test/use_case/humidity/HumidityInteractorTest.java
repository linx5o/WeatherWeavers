package use_case.humidity;

import org.junit.Before;
import org.junit.Test;

import entity.Humidity;
import entity.Settings;

import java.time.LocalTime;
import java.util.ArrayList;

public class HumidityInteractorTest {

    private HumidityDataAccessInterface humidityDataAccessObject;
    private HumidityDataAccessInterface humidityDataAccessObjectFail;
    private HumidityOutputBoundary humidityPresenter;
    private HumiditySettingDataAccessInterface getSettingsDataAccessObject;
    private Settings settings;
    private Integer humidity = 50;

    @Before
    public void setUp() {
        settings = new Settings(true, true, true, "toronto,ca", new ArrayList<String>());
        humidityDataAccessObject = new HumidityDataAccessInterface() {
            @Override
            public Humidity getHumidity(String city, String time) {
                return new Humidity(humidity);
            }
        };
        humidityDataAccessObjectFail = new HumidityDataAccessInterface() {
            @Override
            public Humidity getHumidity(String city, String time) {
                return null;
            }
        };
        humidityPresenter = new HumidityOutputBoundary() {
            @Override
            public void prepareSuccessView(HumidityOutputData humidityOutputData) {
            }

            @Override
            public void prepareFailView(String message) {
            }
        };
        getSettingsDataAccessObject = new HumiditySettingDataAccessInterface() {
            @Override
            public Settings getSettings() {
                return settings;
            }
        };
    }

    @Test
    public void testExecute() {
        HumidityInteractor humidityInteractor = new HumidityInteractor(humidityDataAccessObject, humidityPresenter, getSettingsDataAccessObject);
        humidityInteractor.execute(new HumidityInputData("toronto,ca"));
        HumidityOutputData humidityOutputData = new HumidityOutputData(new Humidity(humidity));
        assert humidityOutputData.getHumidity().equals(humidity);
        assert humidityOutputData.getDescriptions().equals("Comfortable");

    }

    @Test
    public void testExecuteFail() {
        HumidityInteractor humidityInteractor = new HumidityInteractor(humidityDataAccessObjectFail, humidityPresenter, getSettingsDataAccessObject);
        humidityInteractor.execute(new HumidityInputData("toronto,ca"));
    }

    @Test
    public void testExecuteTime() {
        HumidityInteractor humidityInteractor = new HumidityInteractor(humidityDataAccessObject, humidityPresenter, getSettingsDataAccessObject);
        humidityInteractor.execute(LocalTime.now());
    }

    @Test
    public void testExecuteTimeFail() {
        HumidityInteractor humidityInteractor = new HumidityInteractor(humidityDataAccessObjectFail, humidityPresenter, getSettingsDataAccessObject);
        humidityInteractor.execute(LocalTime.now());
    }
}
