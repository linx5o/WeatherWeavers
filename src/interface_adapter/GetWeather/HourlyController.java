package interface_adapter.GetWeather;

import use_case.hourly.HourlyInputBoundary;
import use_case.hourly.HourlyInputData;

import java.time.LocalTime;

public class HourlyController {
    final HourlyInputBoundary hourlyInteractor;
    public HourlyController(HourlyInputBoundary hourlyInteractor) {
        this.hourlyInteractor = hourlyInteractor;
    }

    public void execute(String city) {
        HourlyInputData hourlyInputData = new HourlyInputData(city);

        hourlyInteractor.execute(hourlyInputData);
    }

    public void execute() {
        hourlyInteractor.execute(LocalTime.now());
    }
}
