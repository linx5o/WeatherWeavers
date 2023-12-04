package entity;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TemperatureUnitTest {
    private TemperatureUnit.Unit currentUnit;

    @Before
    public void setUp() {
        currentUnit = TemperatureUnit.Unit.CELSIUS;
    }

    @Test
    public void testGetCurrentUnit() {
        TemperatureUnit temperatureUnit = new TemperatureUnit(TemperatureUnit.Unit.CELSIUS);
        assertEquals(TemperatureUnit.Unit.CELSIUS, temperatureUnit.getCurrentUnit());
    }

    @Test
    public void testSetCurrentUnit() {
        TemperatureUnit temperatureUnit = new TemperatureUnit(TemperatureUnit.Unit.CELSIUS);
        temperatureUnit.setCurrentUnit(TemperatureUnit.Unit.FAHRENHEIT);
        assertEquals(TemperatureUnit.Unit.FAHRENHEIT, temperatureUnit.getCurrentUnit());
    }
}
