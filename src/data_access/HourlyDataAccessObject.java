package data_access;

import use_case.hourly.HourlyDataAccessInterface;
import java.time.LocalTime;
import java.util.ArrayList;

public class HourlyDataAccessObject implements HourlyDataAccessInterface {
    public ArrayList<LocalTime> getHours(String city, LocalTime localTime) {
        ArrayList<LocalTime> times = new ArrayList<>();
        LocalTime nextHour = localTime.getMinute() == 0 ? localTime : localTime.plusHours(1).withMinute(0).withSecond(0).withNano(0);

        for (int i = 0; i < 5; i++) {
            times.add(nextHour.plusHours(i));
        }
        return times;
    }

    public ArrayList<Integer> getTemps(String city, LocalTime localTime, Boolean celsius) {

    }
}
