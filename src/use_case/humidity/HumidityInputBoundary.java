package use_case.humidity;

import java.time.LocalTime;

public interface HumidityInputBoundary {
    void execute(HumidityInputData humidityInputData);

    void execute(LocalTime localTime);
}
