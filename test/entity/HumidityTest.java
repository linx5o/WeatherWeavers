package entity;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;


public class HumidityTest {
    private String descriptions;
    private Integer humidity;

    @Before
    public void setUp() {
        descriptions = "Comfortable";
        humidity = 50;
    }

    @Test
    public void testHumidity() {
        Humidity humidity = new Humidity(50);
        assert humidity.getHumidity() == 50;
    }

    @Test
    public void testSetHumidity() {
        Humidity humidity = new Humidity(50);
        humidity.setHumidity(60);
        assert humidity.getHumidity() == 60;
    }

    @Test
    public void testSetDescriptions() {
        Humidity humidity = new Humidity(50);
        humidity.setDescriptions();
        assertEquals("Comfortable", humidity.getDescriptions());
    }

    @Test
    public void testGetDescriptions() {
        Humidity humidity = new Humidity(50);
        assertEquals("Comfortable", humidity.getDescriptions());
    }
}
