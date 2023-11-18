package interface_adapter.GetWeather;

import use_case.humidity.HumidityInputBoundary;
import use_case.humidity.HumidityInputData;

public class HumidityController {
    final HumidityInputBoundary humidityUseCaseInteractor;

    public HumidityController(HumidityInputBoundary humidityUseCaseInteractor) {
        this.humidityUseCaseInteractor = humidityUseCaseInteractor;
    }

    public void execute(String city) {
        HumidityInputData humidityInputData = new HumidityInputData(city);

        humidityUseCaseInteractor.execute(humidityInputData);
    }
}
