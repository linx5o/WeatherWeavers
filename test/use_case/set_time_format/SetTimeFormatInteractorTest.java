package use_case.set_time_format;

import entity.Settings;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SetTimeFormatInteractorTest {

    private SetTimeFormatDataAccessInterface setTimeFormatDataAccessObject;
    private SetTimeFormatOutputBoundary setTimeFormatPresenter;
    private Boolean is24HourFormat = true;
    private Settings settings;
    private String messageSuccess = "Current temperature unit is Celsius";
    private String messageFail = "Current temperature unit is Fahrenheit";

    @Before
    public void setUp() {
        settings = new Settings(true, true, is24HourFormat, "london,ca", new ArrayList<String>());
        setTimeFormatDataAccessObject = new SetTimeFormatDataAccessInterface() {
            @Override
            public void toggleTimeFormat() {

            }

            @Override
            public Settings getSettings() {
                return settings;
            }
        };
        setTimeFormatPresenter = new SetTimeFormatOutputBoundary() {
            @Override
            public void prepareSuccessView(SetTimeFormatOutputData setTimeFormatOutputData) {

            }
        };
    }

    @Test
    public void testSetTimeFormatInteractor() {
        SetTimeFormatInteractor setTimeFormatInteractor = new SetTimeFormatInteractor(setTimeFormatDataAccessObject, setTimeFormatPresenter);
        SetTimeFormatOutputData setTimeFormatOutputData = new SetTimeFormatOutputData(setTimeFormatDataAccessObject.getSettings().getTimeFormat());
        assertEquals(setTimeFormatOutputData.getIs24HourFormat(), is24HourFormat);
        assertEquals(messageSuccess, setTimeFormatOutputData.getMessage());
        setTimeFormatInteractor.execute();
    }

    @Test
    public void testSetTimeFormatInteractor2() {
        SetTimeFormatInteractor setTimeFormatInteractor = new SetTimeFormatInteractor(setTimeFormatDataAccessObject, setTimeFormatPresenter);
        SetTimeFormatOutputData setTimeFormatOutputData = new SetTimeFormatOutputData(!setTimeFormatDataAccessObject.getSettings().getTimeFormat());
        assertEquals(setTimeFormatOutputData.getIs24HourFormat(), !is24HourFormat);
        assertEquals(messageFail, setTimeFormatOutputData.getMessage());
        setTimeFormatInteractor.execute();
    }

}
