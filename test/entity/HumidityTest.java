package entity;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class HumidityTest {
    private String descriptions;
    private Integer humidity;

    @Test
    public void setUp() {
        descriptions = "Comfortable";
        humidity = 50;
    }

    @Test
    public void testHumidity() {
        Humidity humidity = new Humidity(50);
        assertEquals(Optional.of(50), humidity.getHumidity());
    }

    @Test
    public void testSetHumidity() {
        Humidity humidity = new Humidity(50);
        humidity.setHumidity(60);
        assertEquals(Optional.of(60), humidity.getHumidity());
    }

    @Test
    public void testSetDescriptions() {
        Humidity humidity = new Humidity(50);
        humidity.setDescriptions();
        assertEquals(Optional.of("Comfortable"), humidity.getDescriptions());
    }

    @Test
    public void testGetDescriptions() {
        Humidity humidity = new Humidity(50);
        assertEquals(Optional.of("Comfortable"), humidity.getDescriptions());
    }
}
