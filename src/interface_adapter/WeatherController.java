package interface_adapter;
import use_case.weatherInputBoundary;
import use_case.weatherInputData;
public class WeatherController {

    final weatherInputBoundary weatherUseCaseInteractor;
    public WeatherController(weatherInputBoundary weatherUseCaseInteractor) {
        this.weatherUseCaseInteractor = weatherUseCaseInteractor;
    }

    public void execute(String country, String city) {
        WeatherInputData weatherInputData = new WeatherInputData(
                country, city);

        weatherUseCaseInteractor.execute(weatherInputData);
        }
    }
}
