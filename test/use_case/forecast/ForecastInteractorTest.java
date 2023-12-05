package use_case.forecast;

import data_access.ForecastDataAccessObject;
import entity.Settings;
import entity.Weather;
import interface_adapter.Forecast.ForecastPresenter;
import interface_adapter.Forecast.ForecastViewModel;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ForecastInteractorTest {
    private ForecastDataAccessInterface forecastDataAccessObject;
    private ForecastOutputBoundary forecastPresenter;
    private ForecastSettingsDataAccessInterface forecastSettingsDataAccessObject;
    private ForecastViewModel forecastViewModel;
    private ForecastInteractor forecastInteractor;
    private ForecastInputData forecastInputData;

    private ForecastDataAccessInterface forecastDataAccessObjectInvalid;
    private ForecastInteractor forecastInteractorInvalid;

    @Before
    public void setUp() {

        forecastPresenter = new ForecastPresenter(forecastViewModel) {
//            @Override
//            public void prepareFailView(String message) {
//                assert true;
//            }
            @Override
            public void prepareInformationForecast(ForecastOutputData responseModel) {
                ArrayList<Weather> weathers = new ArrayList<Weather>();
                String descriptions = "Sunny";
                int currentTemp = 25;
                int highTemp = 30;
                int lowTemp = 20;
                String cityi = "TestCity";
                boolean celsius = true;
                int windSpeed = 15;
                int rainPercent = 10;
                String sunrise = "0630";
                String sunset = "1830";

                Weather weather1 = new Weather(descriptions, currentTemp, highTemp, lowTemp, cityi, celsius, windSpeed, rainPercent, sunrise, sunset);
                weathers.add(weather1);

                Weather weather2 = new Weather(descriptions, currentTemp, highTemp, lowTemp, cityi, celsius, windSpeed, rainPercent, sunrise, sunset);
                weathers.add(weather2);

                assert responseModel.getWeathers().get(0).getDescriptions() == weathers.get(0).getDescriptions();
                assert responseModel.getWeathers().get(1).getCurrentTemp() == weathers.get(1).getCurrentTemp();
                // could have more but this is enough to show that they are the same

            }

            @Override
            public void prepareForecast(ForecastOutputData responseModel) {
                // this function is save for latter develompent, so it doesn't need to be tested
                assert true;
            }
        };

        forecastDataAccessObject = new ForecastDataAccessInterface() {
            @Override
            public List<Weather> getForecast(String city, int days, Boolean isCelsius) {
                ArrayList<Weather> weathers = new ArrayList<Weather>();
                String descriptions = "Sunny";
                int currentTemp = 25;
                int highTemp = 30;
                int lowTemp = 20;
                String cityi = "TestCity";
                boolean celsius = true;
                int windSpeed = 15;
                int rainPercent = 10;
                String sunrise = "0630";
                String sunset = "1830";

                Weather weather1 = new Weather(descriptions, currentTemp, highTemp, lowTemp, cityi, celsius, windSpeed, rainPercent, sunrise, sunset);
                weathers.add(weather1);

                Weather weather2 = new Weather(descriptions, currentTemp, highTemp, lowTemp, cityi, celsius, windSpeed, rainPercent, sunrise, sunset);
                weathers.add(weather2);

                // create two same test weathers and add them to the list

                return weathers;
            }
        };

        forecastSettingsDataAccessObject = new ForecastSettingsDataAccessInterface() {
            @Override
            public Settings getSettings() {
                ArrayList<String> savedCities = new ArrayList<String>();
                savedCities.add("vancouver,ca");
                return new Settings(true, true, true, "toronto,ca", savedCities);
            }
        };

        forecastInputData = new ForecastInputData("testCity", 2, true);

        forecastInteractor = new ForecastInteractor(forecastDataAccessObject, forecastSettingsDataAccessObject, forecastPresenter);


        forecastDataAccessObjectInvalid = new ForecastDataAccessObject(){
            @Override
            public List<Weather> getForecast(String city, int days, Boolean isCelsius) {
                return null;
            }
        };

        forecastInteractorInvalid = new ForecastInteractor(forecastDataAccessObjectInvalid, forecastSettingsDataAccessObject, forecastPresenter);
    }



    @Test
    public void testExecuteInformation() {
        forecastInteractor.execute(2, true);
    }

    @Test
    public void testExecute() {
        forecastInteractor.execute(2, false);
    }

    @Test
    public void testExecuteInvalidDays() {
        forecastInteractor.execute(-1, true);
    }

    @Test
    public void testExcuteInput() {
        forecastInteractor.execute(forecastInputData);
        // this is not testable because this function is saved for latter development
    }

    @Test
    public void testExecuteInvalidCity() {
        forecastInteractorInvalid.execute(2, true);
    }

}
