package interface_adapter.GetWeather;

import java.util.ArrayList;
import java.util.List;

public class OtherCitiesState {
    private List<CityWeather> otherCitiesWeather;

    public OtherCitiesState() {
        this.otherCitiesWeather = new ArrayList<>();
    }

    public List<CityWeather> getOtherCitiesWeather() {
        return otherCitiesWeather;
    }

    public void setOtherCitiesWeather(List<CityWeather> otherCitiesWeather) {
        this.otherCitiesWeather = otherCitiesWeather;
    }

    // Inner class to represent weather data for a city
    public static class CityWeather {
        private String cityName;
        private double temperature;
        private int humidity;
        private String weatherCondition;

        public CityWeather(String cityName, double temperature, int humidity, String weatherCondition) {
            this.cityName = cityName;
            this.temperature = temperature;
            this.humidity = humidity;
            this.weatherCondition = weatherCondition;
        }

        // Getters and setters
        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public String getWeatherCondition() {
            return weatherCondition;
        }

        public void setWeatherCondition(String weatherCondition) {
            this.weatherCondition = weatherCondition;
        }
    }
}
