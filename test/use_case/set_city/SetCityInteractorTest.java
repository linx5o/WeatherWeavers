package use_case.set_city;

import entity.Settings;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.fail;

public class SetCityInteractorTest {

    private SetCityDataAccessInterface setCityDataAccessObject;
    private SetCityDataAccessInterface setCityDataAccessObjectFail1;
    private SetCityDataAccessInterface setCityDataAccessObjectFail2;
    private SetCityDataAccessInterface setCityDataAccessObjectFail3;
    private SetCityOutputBoundary setCityPresenter;
    private Settings settings;

    @Before
    public void setUp() {
        settings = new Settings(true, true, true, "london,ca", new ArrayList<String>());
        setCityDataAccessObject = new SetCityDataAccessInterface() {
            @Override
            public int addCity(String city) {
                return 0;
            }

            @Override
            public Settings getSettings() {
                return settings;
            }
        };
        setCityDataAccessObjectFail1 = new SetCityDataAccessInterface() {
            @Override
            public int addCity(String city) {
                return 1;
            }

            @Override
            public Settings getSettings() {
                return settings;
            }
        };
        setCityDataAccessObjectFail2 = new SetCityDataAccessInterface() {
            @Override
            public int addCity(String city) {
                return 2;
            }

            @Override
            public Settings getSettings() {
                return settings;
            }
        };
        setCityDataAccessObjectFail3 = new SetCityDataAccessInterface() {
            @Override
            public int addCity(String city) {
                return 3;
            }

            @Override
            public Settings getSettings() {
                return settings;
            }
        };
        setCityPresenter = new SetCityOutputBoundary() {
            private String successMessage;
            private String errorMessage;
            private String cityName = "";
            private ArrayList<String> cities;
            @Override
            public void prepareSuccessView(SetCityOutputData setCityOutputData, String success) {
                successMessage = success;
                cityName = setCityOutputData.getCity();
                cities = setCityOutputData.getCities();
                if (!cityName.equals("london,ca")) {
                    fail();
                }
                else {
                    errorMessage = "";
                }
            }

            @Override
            public void prepareFailView(String error) {
                errorMessage = error;
            }

            public String getSuccessMessage() {
                return successMessage;
            }

            public String getErrorMessage() {
                return errorMessage;
            }

            public String getCityName() {
                return cityName;
            }
        };
    }

    @Test
    public void testSetCityInteractor() {
        SetCityInputBoundary setCityInteractor = new SetCityInteractor(setCityPresenter, setCityDataAccessObject);
        SetCityInputData setCityInputData = new SetCityInputData("london,ca");
        setCityInteractor.execute(setCityInputData);
    }

    @Test
    public void testSetCityInteractorFail1() {
        SetCityInputBoundary setCityInteractor = new SetCityInteractor(setCityPresenter, setCityDataAccessObjectFail1);
        SetCityInputData setCityInputData = new SetCityInputData("london,ca");
        setCityInteractor.execute(setCityInputData);
    }

    @Test
    public void testSetCityInteractorFail2() {
        SetCityInputBoundary setCityInteractor = new SetCityInteractor(setCityPresenter, setCityDataAccessObjectFail2);
        SetCityInputData setCityInputData = new SetCityInputData("london,ca");
        setCityInteractor.execute(setCityInputData);
    }

    @Test
    public void testSetCityInteractorFail3() {
        SetCityInputBoundary setCityInteractor = new SetCityInteractor(setCityPresenter, setCityDataAccessObjectFail3);
        SetCityInputData setCityInputData = new SetCityInputData("london,ca");
        setCityInteractor.execute(setCityInputData);
    }
}
