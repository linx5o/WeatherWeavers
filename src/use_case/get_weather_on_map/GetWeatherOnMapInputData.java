package use_case.get_weather_on_map;

public class GetWeatherOnMapInputData {
    private final String city;

    public GetWeatherOnMapInputData(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
    }
}
