package use_case.hourly;

import java.time.LocalTime;

public interface HourlyInputBoundary {
    void execute(HourlyInputData hourlyInputData);

    void execute(LocalTime localTime);
}
