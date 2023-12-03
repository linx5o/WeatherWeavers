package interface_adapter.Humidity;

import use_case.humidity.HumidityInputBoundary;
import use_case.humidity.HumidityInputData;

import java.time.LocalTime;

public class HumidityController {
    final HumidityInputBoundary humidityUseCaseInteractor;

    public HumidityController(HumidityInputBoundary humidityUseCaseInteractor) {
        this.humidityUseCaseInteractor = humidityUseCaseInteractor;
    }

    public void execute(String city) {
        HumidityInputData humidityInputData = new HumidityInputData(city);

        humidityUseCaseInteractor.execute(humidityInputData);
    }

    public void execute() {
        humidityUseCaseInteractor.execute(LocalTime.now());
    }
}
