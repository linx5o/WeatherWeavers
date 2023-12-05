package use_case.hourly;

import entity.Settings;
import interface_adapter.Hourly.HourlyPresenter;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;


public class HourlyInteractorTest {
    private HourlyOutputBoundary hourlyPresenter;
    private HourlyDataAccessInterface hourlyDataAccessObject;
    private HourlySettingsDataAccessInterface hourlySettingsDataAccessObject;
    private HourlySettingsDataAccessInterface hourlySettingsDataAccessObjectFail;
    private Settings settings;
    private ArrayList<LocalTime> hours = new ArrayList<LocalTime>();
    private ArrayList<Integer> temps = new ArrayList<Integer>();

    @Before
    public void setUp() {
        hours.add(LocalTime.of(0, 0));
        hours.add(LocalTime.of(1, 0));
        hours.add(LocalTime.of(2, 0));
        temps.add(0);
        temps.add(1);
        temps.add(2);
        settings = new Settings(true, true, true, "london,ca", new ArrayList<String>());
        hourlyPresenter = new HourlyOutputBoundary() {
            @Override
            public void prepareSuccessView(HourlyOutputData hourlyOutputData) {

            }

            @Override
            public void prepareFailView(String error) {

            }
        };
        hourlyDataAccessObject = new HourlyDataAccessInterface() {
            @Override
            public ArrayList<LocalTime> getHours(String city, LocalTime time) {
                ArrayList<LocalTime> hours = new ArrayList<LocalTime>();
                hours.add(LocalTime.of(0, 0));
                hours.add(LocalTime.of(1, 0));
                hours.add(LocalTime.of(2, 0));
                return hours;
            }

            @Override
            public ArrayList<Integer> getTemps(String city, LocalTime time, Boolean celsius) {
                ArrayList<Integer> temps = new ArrayList<Integer>();
                temps.add(0);
                temps.add(1);
                temps.add(2);
                return temps;
            }
        };
        hourlySettingsDataAccessObject = new HourlySettingsDataAccessInterface() {
            @Override
            public Settings getSettings() {
                return settings;
            }
        };
        hourlySettingsDataAccessObjectFail = new HourlySettingsDataAccessInterface() {
            @Override
            public Settings getSettings() {
                return null;
            }
        };
    }

    @Test
    public void testHourlyInteractor() {
        HourlyInteractor hourlyInteractor = new HourlyInteractor(hourlyPresenter, hourlyDataAccessObject, hourlySettingsDataAccessObject);
        HourlyInputData hourlyInputData = new HourlyInputData("london,ca");
        HourlyOutputData hourlyOutputData = new HourlyOutputData(hourlyDataAccessObject.getHours(hourlyInputData.getCity(), hourlyInputData.getTime()), hourlyDataAccessObject.getTemps(hourlyInputData.getCity(), hourlyInputData.getTime(), hourlySettingsDataAccessObject.getSettings().getCelsius()), hourlySettingsDataAccessObject.getSettings().getTimeFormat());
        assert hourlyOutputData.getTimeFormat();
        assert hourlyOutputData.getHours().equals(hours);
        assert hourlyOutputData.getTemps().equals(temps);
        hourlyInteractor.execute(hourlyInputData);
    }

    @Test
    public void testHourlyInteractor2() {
        HourlyInteractor hourlyInteractor = new HourlyInteractor(hourlyPresenter, hourlyDataAccessObject, hourlySettingsDataAccessObject);
        LocalTime localTime = LocalTime.of(0, 0);
        HourlyOutputData hourlyOutputData = new HourlyOutputData(hourlyDataAccessObject.getHours(hourlySettingsDataAccessObject.getSettings().getDefaultCity(), localTime), hourlyDataAccessObject.getTemps(hourlySettingsDataAccessObject.getSettings().getDefaultCity(), localTime, hourlySettingsDataAccessObject.getSettings().getCelsius()), hourlySettingsDataAccessObject.getSettings().getTimeFormat());
        hourlyInteractor.execute(localTime);
    }

    @Test
    public void testHourlyInteractorFail() {
        HourlyInteractor hourlyInteractor = new HourlyInteractor(hourlyPresenter, hourlyDataAccessObject, hourlySettingsDataAccessObjectFail);
        HourlyInputData hourlyInputData = new HourlyInputData("london,ca");
        hourlyInteractor.execute(hourlyInputData);
    }

    @Test
    public void testHourlyInteractorFail2() {
        HourlyInteractor hourlyInteractor = new HourlyInteractor(hourlyPresenter, hourlyDataAccessObject, hourlySettingsDataAccessObjectFail);
        LocalTime localTime = LocalTime.of(0, 0);
        hourlyInteractor.execute(localTime);
    }
}
