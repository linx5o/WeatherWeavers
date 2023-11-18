package use_case.hourly;

import java.time.LocalTime;
import java.util.ArrayList;

public class HourlyOutputData {

    private final ArrayList<LocalTime> hours;
    private final ArrayList<Integer> temps;
    private final Boolean timeFormat;

    public HourlyOutputData(ArrayList<LocalTime> hours, ArrayList<Integer> temps, Boolean timeFormat) {
        this.hours = hours;
        this.temps = temps;
        this.timeFormat = timeFormat;
    }

    public ArrayList<LocalTime> getHours() {
        return this.hours;
    }

    public ArrayList<Integer> getTemps() {
        return this.temps;
    }

    public Boolean getTimeFormat() {
        return this.timeFormat;
    }
}
