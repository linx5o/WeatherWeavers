package use_case.get_weather;

import entity.Weather;

public class GetWeatherOutputData {

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
    private final Boolean timeFormat;

    public GetWeatherOutputData(Weather weather, Boolean timeFormat) {
        this.descriptions = weather.getDescriptions();
        this.currentTemp = weather.getCurrentTemp();
        this.highTemp = weather.getHighTemp();
        this.lowTemp = weather.getLowTemp();
        this.city = weather.getCity();
        this.celsius = weather.getCelsius();
        this.windSpeed = weather.getWindSpeed();
        this.rainPercent = weather.getRainPercent();
        this.sunrise = weather.getSunrise();
        this.sunset = weather.getSunset();
        this.weekDay = weather.getWeekDay();
        this.date = weather.getDate();
        this.timeFormat = timeFormat;
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

    public Boolean getTimeFormat() {
        return this.timeFormat;
    }

}
