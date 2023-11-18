package use_case.hourly;

import java.time.LocalTime;
import java.util.ArrayList;

public interface HourlyDataAccessInterface {
    ArrayList<LocalTime> getHours(String city, LocalTime time);
    ArrayList<Integer> getTemps(String city, ArrayList<LocalTime> hours, Boolean celsius);
}
