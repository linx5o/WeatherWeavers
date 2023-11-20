package use_case.get_other_cities;

import java.util.List;

public class GetOtherCitiesOutputData {
    private final List<CityWeatherInfo> citiesWeatherInfo;

    public GetOtherCitiesOutputData(List<CityWeatherInfo> citiesWeatherInfo) {
        this.citiesWeatherInfo = citiesWeatherInfo;
    }

    // Getter
    public List<CityWeatherInfo> getCitiesWeatherInfo() {
        return citiesWeatherInfo;
    }

    public static class CityWeatherInfo {
        private final String cityName;
        private final String weatherDescription;
        private final double temperature;

        public CityWeatherInfo(String cityName, String weatherDescription, double temperature) {
            this.cityName = cityName;
            this.weatherDescription = weatherDescription;
            this.temperature = temperature;
        }

        // Getters
        public String getCityName() {
            return cityName;
        }

        public String getWeatherDescription() {
            return weatherDescription;
        }

        public double getTemperature() {
            return temperature;
        }
    }
}


