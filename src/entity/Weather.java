package entity;

import java.time.LocalDate;

public class Weather {
    private final String descriptions;
    private final Integer currentTemp;
    private final Integer highTemp;
    private final Integer lowTemp;
    private final String city;
    private final Boolean celsius;
    private final Integer windSpeed;
    private final Integer rainPercent; // in percentage
    private final String sunrise; // first 2 digits are hours, last 2 digits are minutes
    private final String sunset; // first 2 digits are hours, last 2 digits are minutes
    private final String weekDay;
    private final String date;

    public Weather(String descriptions, Integer currentTemp, Integer highTemp, Integer lowTemp, String city, Boolean celsius, Integer windSpeed, Integer rainPercent, String sunrise, String sunset) {
        this.descriptions = descriptions;
        this.currentTemp = currentTemp;
        this.highTemp = highTemp;
        this.lowTemp = lowTemp;
        this.city = city;
        this.celsius = celsius;
        this.windSpeed = windSpeed;
        this.rainPercent = rainPercent;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.weekDay = LocalDate.now().getDayOfWeek().toString();
        this.date = LocalDate.now().toString();
    }

    public String getDescriptions() {
        return this.descriptions;
    }

    public Integer getCurrentTemp() {
        return this.currentTemp;
    }

    public Integer getHighTemp() {
        return this.highTemp;
    }

    public Integer getLowTemp() {
        return this.lowTemp;
    }

    public String getCity() {
        return this.city;
    }

    public Boolean getCelsius() {
        return this.celsius;
    }

    public Integer getWindSpeed() {
        return this.windSpeed;
    }

    public Integer getRainPercent() {
        return this.rainPercent;
    }

    public String getSunrise() {
        return this.sunrise;
    }

    public String getSunset() {
        return this.sunset;
    }

    public String getWeekDay() {
        return this.weekDay;
    }

    public String getDate() {
        return this.date;
    }
}
