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
    public void testSetHumidity90() {
        Humidity humidity = new Humidity(50);
        humidity.setHumidity(90);
        assert humidity.getHumidity() == 90;
    }

    @Test
    public void testSetHumidity80() {
        Humidity humidity = new Humidity(50);
        humidity.setHumidity(80);
        assert humidity.getHumidity() == 80;
    }

    @Test
    public void testSetHumidity70() {
        Humidity humidity = new Humidity(50);
        humidity.setHumidity(70);
        assert humidity.getHumidity() == 70;
    }

    @Test
    public void testSetHumidity40() {
        Humidity humidity = new Humidity(50);
        humidity.setHumidity(40);
        assert humidity.getHumidity() == 40;
    }

    @Test
    public void testSetHumidity30() {
        Humidity humidity = new Humidity(50);
        humidity.setHumidity(30);
        assert humidity.getHumidity() == 30;
    }

    @Test
    public void testSetHumidity20() {
        Humidity humidity = new Humidity(50);
        humidity.setHumidity(20);
        assert humidity.getHumidity() == 20;
    }

    @Test
    public void testSetHumidity10() {
        Humidity humidity = new Humidity(50);
        humidity.setHumidity(10);
        assert humidity.getHumidity() == 10;
    }

    @Test
    public void testSetHumidity95() {
        Humidity humidity = new Humidity(50);
        humidity.setHumidity(95);
        assert humidity.getHumidity() == 95;
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
