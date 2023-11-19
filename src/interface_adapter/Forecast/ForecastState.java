package interface_adapter.Forecast;

import entity.Location;
import entity.Weather;

import java.util.List;

public class ForecastState {
    private Location location;
    private int days;
    private boolean information;
    private List<Weather> wetherList;

    public ForecastState(Location location, int days, boolean information, List<Weather> wetherList) {
        this.location = location;
        this.days = days;
        this.information = information;
        this.wetherList = wetherList;
    }

    public ForecastState() {

    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public boolean isInformation() {
        return information;
    }

    public void setInformation(boolean information) {
        this.information = information;
    }

    public List<Weather> getWetherList() {
        return wetherList;
    }

    public void setWetherList(List<Weather> wetherList) {
        this.wetherList = wetherList;
    }
}