package use_case.set_city;

import entity.Settings;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SetCityInteractorTest {

    private SetCityDataAccessInterface setCityDataAccessObject;
    private SetCityDataAccessInterface setCityDataAccessObjectFail1;
    private SetCityDataAccessInterface setCityDataAccessObjectFail2;
    private SetCityDataAccessInterface setCityDataAccessObjectFail3;
    private SetCityDataAccessInterface setCityDataAccessObjectFail4;
    private SetCityDataAccessInterface setCityDataAccessObjectFail5;
    private SetCityOutputBoundary setCityPresenter;
    private Settings settings;
    private ArrayList<String> cities = new ArrayList<String>();

    @Before
    public void setUp() {
        settings = new Settings(true, true, true, "london,ca", new ArrayList<String>());
        cities.add("london,ca");
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
        setCityDataAccessObjectFail4 = new SetCityDataAccessInterface() {
            @Override
            public int addCity(String city) {
                return 4;
            }

            @Override
            public Settings getSettings() {
                return settings;
            }
        };
        setCityDataAccessObjectFail5 = new SetCityDataAccessInterface() {
            @Override
            public int addCity(String city) {
                return 5;
            }

            @Override
            public Settings getSettings() {
                return settings;
            }
        };
        setCityPresenter = new SetCityOutputBoundary() {
            private String successMessage;
            private String errorMessage;
//            private String cityName = "";
            private ArrayList<String> cities;
            @Override
            public void prepareSuccessView(SetCityOutputData setCityOutputData, String success) {
                successMessage = success;
                cities = setCityOutputData.getCity();
                if (cities == null) {
                    fail();
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

            public ArrayList<String> getCities() {
                return cities;
            }
        };
    }

    @Test
    public void testSetCityInteractor() {
        SetCityInputBoundary setCityInteractor = new SetCityInteractor(setCityPresenter, setCityDataAccessObject);
        SetCityInputData setCityInputData = new SetCityInputData("london,ca");
        SetCityOutputData setCityOutputData = new SetCityOutputData(setCityDataAccessObject.getSettings().getSavedCities());
        assertEquals(setCityOutputData.getCity(), cities);
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

    @Test
    public void testSetCityInteractorFail4() {
        SetCityInputBoundary setCityInteractor = new SetCityInteractor(setCityPresenter, setCityDataAccessObjectFail4);
        SetCityInputData setCityInputData = new SetCityInputData("london,ca");
        setCityInteractor.execute(setCityInputData);
    }

    @Test
    public void testSetCityInteractorFail5() {
        SetCityInputBoundary setCityInteractor = new SetCityInteractor(setCityPresenter, setCityDataAccessObjectFail5);
        SetCityInputData setCityInputData = new SetCityInputData("london,ca");
        setCityInteractor.execute(setCityInputData);
    }
}
