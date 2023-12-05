package use_case.get_weather_on_map;

import data_access.GetWeatherOnMapDataAccessObject;
import entity.Settings;
import interface_adapter.GetWeatherOnMap.GetWeatherOnMapPresenter;
import interface_adapter.GetWeatherOnMap.GetWeatherOnMapViewModel;
import org.junit.Before;
import org.junit.Test;
import use_case.forecast.ForecastSettingsDataAccessInterface;
import use_case.get_weather.GetSettingsDataAccessInterface;

import javax.swing.*;
import java.util.ArrayList;

public class GetWeatherOnMapInteractorTest {
    private GetWeatherOnMapInteractor getWeatherOnMapInteractor;
    private GetWeatherOnMapDataAccessInterface getWeatherOnMapDataAccessObject;
    private GetWeatherOnMapOutputBoundary getWeatherOnMapPresenter;
    private GetWeatherOnMapSettingDataAccessInterface getSettingsDataAccessObject;

    @Before
    public void setUp() {
        getSettingsDataAccessObject = new GetWeatherOnMapSettingDataAccessInterface() {
            @Override
            public Settings getSettings() {
                ArrayList<String> savedCities = new ArrayList<String>();
                savedCities.add("vancouver,ca");
                return new Settings(true, true, true, "toronto,ca", savedCities);
            }
        };

        getWeatherOnMapPresenter = new GetWeatherOnMapPresenter(new GetWeatherOnMapViewModel()) {
            @Override
            public void prepareWeatherPage(GetWeatherOnMapOutputData getWeatherOnMapOutputData) {
                assert true;
                // this is a Jpanel, so we can't really test it
            }
        };

        getWeatherOnMapDataAccessObject = new GetWeatherOnMapDataAccessObject() {
            @Override
            public JPanel getWeatherOnMap() {
                assert true;
                return new JPanel();
                // this is a Jpanel, so we can't really test it
            }
        };


        getWeatherOnMapInteractor = new GetWeatherOnMapInteractor(getWeatherOnMapDataAccessObject, getWeatherOnMapPresenter, getSettingsDataAccessObject);
    }


    @Test
    public void testExecute() {
        getWeatherOnMapInteractor.execute(new GetWeatherOnMapInputData());
    }
}
