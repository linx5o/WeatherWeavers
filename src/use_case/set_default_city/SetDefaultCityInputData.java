package use_case.set_default_city;

public class SetDefaultCityInputData {

    final private String cityName;

    public SetDefaultCityInputData(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }
}
