package use_case.get_other_cities;


public class GetOtherCitiesOutputData {
    private final String cityName;
    private final String weatherDescription;
    private final double temperature;

    public GetOtherCitiesOutputData(String cityName, String weatherDescription, double temperature) {
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


