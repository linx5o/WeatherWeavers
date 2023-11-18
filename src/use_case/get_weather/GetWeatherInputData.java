package use_case.get_weather;

import java.time.LocalTime;

public class GetWeatherInputData {

    final private String city;

    public GetWeatherInputData(String city) {
        this.city = city;
    }

    public String getCity() {return city;}

    public String getTime() {
        LocalTime localTime = LocalTime.now();
        return localTime.toString();
    }
}
