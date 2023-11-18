package use_case.forecast;

import entity.Weather;

import java.util.List;

public class ForcastOutputData {
    private final int days;
    private final List<Weather> weathers;
    private final boolean information;

    public ForcastOutputData(int days, List<Weather> weathers, boolean information) {
        this.days = days;
        this.weathers = weathers;
        this.information = information;
    }

    public int getDays() {
        return days;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }

    public boolean isInformation(){
        return information;
    }
}
