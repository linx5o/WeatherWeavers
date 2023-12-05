package use_case.erase_city;

import org.junit.Before;
import org.junit.Test;

import entity.Settings;
import use_case.erase_city.EraseCityDataAccessInterface;
import use_case.erase_city.EraseCityOutputBoundary;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class EraseCityInteractorTest {

    private EraseCityDataAccessInterface eraseCityDataAccessObject;
    private EraseCityDataAccessInterface eraseCityDataAccessObjectFail;
    private EraseCityOutputBoundary eraseCityPresenter;
    private Settings settings;
    private ArrayList<String> cities = new ArrayList<String>();

    @Before
    public void setUp() {
        settings = new Settings(true, true, true, "toronto,ca", new ArrayList<String>());
        cities.add("london,ca");
        eraseCityDataAccessObject = new EraseCityDataAccessInterface() {
            @Override
            public Boolean eraseCity(String city) {
                settings.getSavedCities().remove(city);
                return true;
            }

            @Override
            public Settings getSettings() {
                return settings;
            }
        };
        eraseCityDataAccessObjectFail = new EraseCityDataAccessInterface() {
            @Override
            public Boolean eraseCity(String city) {
                return false;
            }

            @Override
            public Settings getSettings() {
                return settings;
            }
        };
        eraseCityPresenter = new EraseCityOutputBoundary() {
            @Override
            public void prepareSuccessView(EraseCityOutputData eraseCityOutputData, String success) {

            }

            @Override
            public void prepareFailView(String error) {

            }
        };
    }

    @Test
    public void testEraseCity() {
        EraseCityInputBoundary eraseCityInteractor = new EraseCityInteractor( eraseCityPresenter, eraseCityDataAccessObject);
        EraseCityInputData eraseCityInputData = new EraseCityInputData("london,ca");
        eraseCityInteractor.execute(eraseCityInputData);
        EraseCityOutputData eraseCityOutputData = new EraseCityOutputData(settings.getSavedCities());
        assertEquals(0, eraseCityOutputData.getCity().size());
        assertEquals(0, settings.getSavedCities().size());
    }

    @Test
    public void testEraseCityFail() {
        EraseCityInputBoundary eraseCityInteractor = new EraseCityInteractor( eraseCityPresenter, eraseCityDataAccessObjectFail);
        EraseCityInputData eraseCityInputData = new EraseCityInputData("london,ca");
        eraseCityInteractor.execute(eraseCityInputData);
    }
}
