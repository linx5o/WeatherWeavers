package use_case.humidity;

import entity.Humidity;
import use_case.get_weather.GetSettingsDataAccessInterface;

import java.time.LocalTime;

public class HumidityInteractor implements HumidityInputBoundary{
    final HumidityDataAccessInterface humidityDataAccessObject;
    final HumidityOutputBoundary humidityPresenter;
    final GetSettingsDataAccessInterface getSettingsDataAccessObject;
    public HumidityInteractor(HumidityDataAccessInterface humidityDataAccessObject, HumidityOutputBoundary humidityOutputBoundary, GetSettingsDataAccessInterface getSettingsDataAccessObject) {
        this.humidityDataAccessObject = humidityDataAccessObject;
        this.humidityPresenter = humidityOutputBoundary;
        this.getSettingsDataAccessObject = getSettingsDataAccessObject;
    }

    @Override
    public void execute(HumidityInputData humidityInputData) {
        Humidity humidity = humidityDataAccessObject.getHumidity(humidityInputData.getCity(), humidityInputData.getTime());
        if (humidity == null) {
            humidityPresenter.prepareFailView("Error");
        } else {
            humidityPresenter.prepareSuccessView(new HumidityOutputData(humidity));
        }
    }

    @Override
    public void execute(LocalTime localTime) {
        Humidity humidity = humidityDataAccessObject.getHumidity(getSettingsDataAccessObject.getSettings().getDefaultCity(), localTime.toString());
        if (humidity == null) {
            humidityPresenter.prepareFailView("Error");
        } else {
            humidityPresenter.prepareSuccessView(new HumidityOutputData(humidity));
        }
    }
}
