package use_case.set_temp_unit;

import entity.Settings;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SetTempUnitInteractorTest {

    private SetTempUnitOutputBoundary setTempUnitPresenter;
    private SetTempUnitDataAccessInterface setTempUnitDataAccessObject;
    private SetTempUnitDataAccessInterface setTempUnitDataAccessObjectFail;
    private Boolean isCelsius = true;
    private Settings settings;
    private String message;

    @Before
    public void setUp() {
        settings = new Settings(isCelsius, true, true, "london,ca", new ArrayList<String>());
        setTempUnitPresenter = new SetTempUnitOutputBoundary() {
            @Override
            public void prepareSuccessView(SetTempUnitOutputData setTempUnitOutputData) {

            }

        };
        setTempUnitDataAccessObject = new SetTempUnitDataAccessInterface() {
            @Override
            public void toggleTempUnit() {
                isCelsius = !isCelsius;
            }

            @Override
            public Settings getSettings() {
                return settings;
            }
        };
    }

    @Test
    public void testSetTempUnitInteractor() {
        SetTempUnitInteractor setTempUnitInteractor = new SetTempUnitInteractor(setTempUnitPresenter, setTempUnitDataAccessObject);
        SetTempUnitOutputData setTempUnitOutputData = new SetTempUnitOutputData(setTempUnitDataAccessObject.getSettings().getCelsius());
        assertEquals(setTempUnitOutputData.isCelsius(), isCelsius);
        message = setTempUnitOutputData.getMessage();
        setTempUnitInteractor.execute();
    }

    @Test
    public void testSetTempUnitInteractor2() {
        SetTempUnitInteractor setTempUnitInteractor = new SetTempUnitInteractor(setTempUnitPresenter, setTempUnitDataAccessObject);
        SetTempUnitOutputData setTempUnitOutputData = new SetTempUnitOutputData(!setTempUnitDataAccessObject.getSettings().getCelsius());
        assertEquals(setTempUnitOutputData.isCelsius(), !isCelsius);
        message = setTempUnitOutputData.getMessage();
        setTempUnitInteractor.execute();
    }
}
