package use_case.hourly;

import java.time.LocalTime;

public class HourlyInputData {

    final private String city;
    final private LocalTime now;

    public HourlyInputData(String city) {
        this.city = city;
        this.now = LocalTime.now();
    }

    public String getCity() {
        return city;
    }

    public LocalTime getTime() {
        return now;
    }
}
