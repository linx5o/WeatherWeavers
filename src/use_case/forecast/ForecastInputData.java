package use_case.forecast;

import entity.Location;

public class ForecastInputData {
    final private String city;
    final private int days;
    final private boolean information;

    public ForecastInputData(String city, int days, boolean information) {
        this.city = city;
        this.days = days;
        this.information = information;
    }

    public String getCity() {
        return city;
    }

    public int getDays() {
        return days;
    }

    public boolean isInformation(){
        return information;
    }
}
