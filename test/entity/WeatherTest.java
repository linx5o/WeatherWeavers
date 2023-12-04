package entity;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;

public class WeatherTest {

    private Weather weather;
    private String descriptions;
    private Integer currentTemp;
    private Integer highTemp;
    private Integer lowTemp;
    private String city;
    private Boolean celsius;
    private Integer windSpeed;
    private Integer rainPercent;
    private String sunrise;
    private String sunset;

    @Before
    public void setUp() {
        descriptions = "Sunny";
        currentTemp = 25;
        highTemp = 30;
        lowTemp = 20;
        city = "TestCity";
        celsius = true;
        windSpeed = 15;
        rainPercent = 10;
        sunrise = "0630";
        sunset = "1830";

        weather = new Weather(descriptions, currentTemp, highTemp, lowTemp, city, celsius, windSpeed, rainPercent, sunrise, sunset);
    }

    @Test
    public void testGetDescriptions() {
        Assert.assertEquals("Descriptions should match the constructor input", descriptions, weather.getDescriptions());
    }

    @Test
    public void testGetCurrentTemp() {
        Assert.assertEquals("Current temperature should match the constructor input", currentTemp, weather.getCurrentTemp());
    }

    // ... Additional tests for other getters ...

    @Test
    public void testGetWeekDay() {
        String expectedWeekDay = LocalDate.now().getDayOfWeek().toString();
        Assert.assertEquals("Weekday should be today's day of the week", expectedWeekDay, weather.getWeekDay());
    }

    @Test
    public void testGetDate() {
        String expectedDate = LocalDate.now().toString();
        Assert.assertEquals("Date should be today's date", expectedDate, weather.getDate());
    }

    @Test
    public void testGetHighTemp() {
        Assert.assertEquals("High temperature should match the constructor input", highTemp, weather.getHighTemp());
    }

    @Test
    public void testGetLowTemp() {
        Assert.assertEquals("Low temperature should match the constructor input", lowTemp, weather.getLowTemp());
    }

    @Test
    public void testGetCity() {
        Assert.assertEquals("City should match the constructor input", city, weather.getCity());
    }

    @Test
    public void testGetCelsius() {
        Assert.assertEquals("Celsius should match the constructor input", celsius, weather.getCelsius());
    }

    @Test
    public void testGetWindSpeed() {
        Assert.assertEquals("Wind speed should match the constructor input", windSpeed, weather.getWindSpeed());
    }

    @Test
    public void testGetRainPercent() {
        Assert.assertEquals("Rain percent should match the constructor input", rainPercent, weather.getRainPercent());
    }

    @Test
    public void testGetSunrise() {
        Assert.assertEquals("Sunrise should match the constructor input", sunrise, weather.getSunrise());
    }

    @Test
    public void testGetSunset() {
        Assert.assertEquals("Sunset should match the constructor input", sunset, weather.getSunset());
    }

    // ... Additional tests for other scenarios ...
}
