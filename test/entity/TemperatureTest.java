package entity;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TemperatureTest {
    private double degreeInC;

    @Before
    public void setUp() {
        degreeInC = 20.0;
    }

    @Test
    public void testGetDegreeInC() {
        Temperature temperature = new Temperature(20.0);
        assertEquals(20.0, temperature.getDegreeInC());
    }

    @Test
    public void testSetDegreeInC() {
        Temperature temperature = new Temperature(20.0);
        temperature.setDegreeInC(30.0);
        assertEquals(30.0, temperature.getDegreeInC());
    }

}
