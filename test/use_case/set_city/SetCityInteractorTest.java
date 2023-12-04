package use_case.set_city;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class SetCityInteractorTest {

    private SetCityDataAccessInterface setCityDataAccessObject;
    private SetCityDataAccessInterface setCityDataAccessObjectFail1;
    private SetCityDataAccessInterface setCityDataAccessObjectFail2;
    private SetCityDataAccessInterface setCityDataAccessObjectFail3;
    private SetCityOutputBoundary setCityPresenter;

    @Before
    public void setUp() {
        setCityDataAccessObject = new SetCityDataAccessInterface() {
            @Override
            public int addCity(String city) {
                return 0;
            }
        };
        setCityDataAccessObjectFail1 = new SetCityDataAccessInterface() {
            @Override
            public int addCity(String city) {
                return 1;
            }
        };
        setCityDataAccessObjectFail2 = new SetCityDataAccessInterface() {
            @Override
            public int addCity(String city) {
                return 2;
            }
        };
        setCityDataAccessObjectFail3 = new SetCityDataAccessInterface() {
            @Override
            public int addCity(String city) {
                return 3;
            }
        };
        setCityPresenter = new SetCityOutputBoundary() {
            private String successMessage;
            private String errorMessage;
            private String cityName = "";
            @Override
            public void prepareSuccessView(SetCityOutputData setCityOutputData, String success) {
                successMessage = success;
                cityName = setCityOutputData.getCity();
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
