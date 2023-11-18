package use_case.forecast;

import entity.Location;

public class ForcastInputData {
    final private Location location;
    final private int days;
    final private boolean information;

    public ForcastInputData(Location location, int days, boolean information) {
        this.location = location;
        this.days = days;
        this.information = information;
    }

    public Location getLocation() {
        return location;
    }

    public int getDays() {
        return days;
    }

    public boolean isInformation(){
        return information;
    }
}