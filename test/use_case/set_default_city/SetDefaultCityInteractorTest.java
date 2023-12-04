package use_case.set_default_city;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SetDefaultCityInteractorTest {

    private SetDefaultCityOutputBoundary setDefaultCityPresenter;
    private SetDefaultCityDataAccessInterface setDefaultCityDataAccessObject;
    private SetDefaultCityDataAccessInterface setDefaultCityDataAccessObjectFail;
    private String addedCityName = "city";

    @Before
    public void setUp() {

        setDefaultCityDataAccessObject = new SetDefaultCityDataAccessInterface() {
            @Override
            public Boolean setDefaultCity(String cityName) {
                return true;
            }
        };
        setDefaultCityDataAccessObjectFail = new SetDefaultCityDataAccessInterface() {
            @Override
            public Boolean setDefaultCity(String cityName) {
                return false;
            }
        };
        setDefaultCityPresenter = new SetDefaultCityOutputBoundary() {
            @Override
            public void prepareSuccessView(SetDefaultCityOutputData setDefaultCityOutputData) {
            }

            @Override
            public void prepareFailView(String error) {
            }
        };
    }

    @Test
    public void testSetDefaultCity() {
        SetDefaultCityInteractor setDefaultCityInteractor = new SetDefaultCityInteractor(setDefaultCityPresenter, setDefaultCityDataAccessObject);
        SetDefaultCityInputData setDefaultCityInputData = new SetDefaultCityInputData("city");
        SetDefaultCityOutputData setDefaultCityOutputData = new SetDefaultCityOutputData(setDefaultCityInputData.getCityName());
        assertEquals(setDefaultCityOutputData.getCityName(), addedCityName);
        setDefaultCityInteractor.execute(setDefaultCityInputData);
    }

    @Test
    public void testSetDefaultCityFail() {
        SetDefaultCityInteractor setDefaultCityInteractor = new SetDefaultCityInteractor(setDefaultCityPresenter, setDefaultCityDataAccessObjectFail);
        SetDefaultCityInputData setDefaultCityInputData = new SetDefaultCityInputData("city");
        setDefaultCityInteractor.execute(setDefaultCityInputData);
    }
}
