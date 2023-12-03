package use_case.set_default_city;

public class SetDefaultCityOutputData {

        final private String cityName;

        public SetDefaultCityOutputData(String cityName) {
            this.cityName = cityName;
        }

        public String getCityName() {
            return cityName;
        }
}
