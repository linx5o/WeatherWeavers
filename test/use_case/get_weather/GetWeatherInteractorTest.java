package use_case.get_weather;

import data_access.GetWeatherDataAccessObject;
import entity.*;
import org.junit.Rule;
import use_case.get_weather.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.time.LocalTime;
import java.time.LocalDate;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;

public class GetWeatherInteractorTest {

    private GetWeatherDataAccessInterface getWeatherDataAccessObject;
    private GetWeatherDataAccessInterface getWeatherDataAccessObjectFail;
    private GetSettingsDataAccessInterface getSettingsDataAccessObject;
//    private GetSettingsDataAccessInterface getSettingsDataAccessObjectFail;
    public GetWeatherOutputBoundary getWeatherPresenter;

    @Before
    public void setUp() {
        getWeatherDataAccessObject = new GetWeatherDataAccessInterface() {
            @Override
            public Weather getCityWeather(String city, String date, Boolean celsius) {
                return new Weather("Sunny", 2, 5, 0, "toronto,ca", true, 14, 0, "0730", "1630");
            }
        };
        getWeatherDataAccessObjectFail = new GetWeatherDataAccessInterface() {
            @Override
            public Weather getCityWeather(String city, String date, Boolean celsius) {
                return null;
            }
        };
        getSettingsDataAccessObject = new GetSettingsDataAccessInterface() {
            @Override
            public Settings getSettings() {
                ArrayList<String> savedCities = new ArrayList<String>();
                savedCities.add("vancouver,ca");
                return new Settings(true, true, true, "toronto,ca", savedCities);
            }
        };
        getWeatherPresenter = new GetWeatherOutputBoundary() {

//            public String presenterState = "";

            @Override
            public void prepareSuccessView(GetWeatherOutputData getWeatherOutputData) {
                LocalDate localTime = LocalDate.now();
                String weekDay = localTime.getDayOfWeek().toString();
                String date = localTime.toString();
//                GetWeatherOutputData getWeatherOutputData1 = new GetWeatherOutputData(new Weather("Sunny", 2, 5, 0, "toronto,ca", true, 14, 0, "0730", "1630"), true);
                if (getWeatherOutputData == null) {
//                    presenterState = "Fail";
                    fail();
                } else if (getWeatherOutputData.getDescriptions().equals("Sunny") && getWeatherOutputData.getCurrentTemp() == 2 && getWeatherOutputData.getHighTemp() == 5 && getWeatherOutputData.getLowTemp() == 0 && getWeatherOutputData.getCity().equals("toronto,ca") && getWeatherOutputData.getCelsius() && getWeatherOutputData.getWindSpeed() == 14 && getWeatherOutputData.getRainPercent() == 0 && getWeatherOutputData.getSunrise().equals("0730") && getWeatherOutputData.getSunset().equals("1630") && getWeatherOutputData.getWeekDay().equals(weekDay) && getWeatherOutputData.getDate().equals(date) && getWeatherOutputData.getTimeFormat()) {
//                    presenterState = "Success";
                } else {
//                    presenterState = "Error";
                    fail();
                }

            }

//            public String getPresenterState() {
////                return presenterState;
//            }

            @Override
            public void prepareFailView(String message) {
//                presenterState = "Fail";
            }
        };
    }

    @Test
    public void testGetWeatherInteractorSuccessPresenter1() {
        GetWeatherInputData getWeatherInputData = new GetWeatherInputData("toronto,ca");
        GetWeatherInteractor getWeatherInteractor = new GetWeatherInteractor(getWeatherDataAccessObject, getSettingsDataAccessObject, getWeatherPresenter);
        getWeatherInteractor.execute(getWeatherInputData);
//        assertEquals(getWeatherPresenter.presenterState, "Success");
    }

    @Test
    public void testGetWeatherInteractorSuccessPresenter2() {
        LocalTime localTime = LocalTime.now();
        GetWeatherInteractor getWeatherInteractor = new GetWeatherInteractor(getWeatherDataAccessObject, getSettingsDataAccessObject, getWeatherPresenter);
        getWeatherInteractor.execute(localTime);
//        assertEquals(presenterState, "Success");
    }

    @Test
    public void testGetWeatherInteractorFailPresenter1() {
        GetWeatherInputData getWeatherInputData = new GetWeatherInputData("toronto,ca");
        GetWeatherInteractor getWeatherInteractor = new GetWeatherInteractor(getWeatherDataAccessObjectFail, getSettingsDataAccessObject, getWeatherPresenter);
        getWeatherInteractor.execute(getWeatherInputData);
//        assertEquals(presenterState, "Fail");
    }

    @Test
    public void testGetWeatherInteractorFailPresenter2() {
        LocalTime localTime = LocalTime.now();
        GetWeatherInteractor getWeatherInteractor = new GetWeatherInteractor(getWeatherDataAccessObjectFail, getSettingsDataAccessObject, getWeatherPresenter);
        getWeatherInteractor.execute(localTime);
//        assertEquals(presenterState, "Fail");
    }
}
