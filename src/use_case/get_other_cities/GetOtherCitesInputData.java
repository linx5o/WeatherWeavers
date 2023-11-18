package use_case.get_other_cities;


public class GetOtherCitesInputData {
    private final String cityName;

    public GetOtherCitesInputData(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }
}
