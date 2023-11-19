package use_case.humidity;

import java.time.LocalTime;

public class HumidityInputData {
    final private String city;

    public HumidityInputData(String city) {
        this.city = city;
    }

    public String getCity() {return city;}

    public String getTime() {
        LocalTime localTime = LocalTime.now();
        return localTime.toString();
    }
}
