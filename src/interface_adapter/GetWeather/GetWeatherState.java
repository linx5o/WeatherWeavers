package interface_adapter.GetWeather;

import javax.swing.*;

public class GetWeatherState {
    private String city = "";
    private String date = "";
    private ImageIcon temperatureIcon = null;
    private String temperature = "";
    private String description = "";
    private String high = "";
    private String low = "";
    private String wind = "";
    private String rain = "";
    private String Sunrise = "";
    private String Sunset = "";

    public GetWeatherState() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ImageIcon getTemperatureIcon() {
        return temperatureIcon;
    }

    public void setTemperatureIcon(ImageIcon icon) {
        this.temperatureIcon = icon;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getSunrise() {
        return Sunrise;
    }

    public void setSunrise(String sunrise) {
        Sunrise = sunrise;
    }

    public String getSunset() {
        return Sunset;
    }

    public void setSunset(String sunset) {
        Sunset = sunset;
    }
}
