package use_case.hourly;

import java.time.LocalTime;
import java.util.ArrayList;

public interface HourlyDataAccessInterface {
    ArrayList<LocalTime> getHours(String city, LocalTime localTime);
    ArrayList<Integer> getTemps(String city, LocalTime localTime, Boolean celsius);
}
