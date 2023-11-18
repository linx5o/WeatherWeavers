package use_case.humidity;

import entity.Humidity;

public class HumidityInteractor implements HumidityInputBoundary{
    final HumidityDataAccessInterface humidityDataAccessObject;
    final HumidityOutputBoundary humidityPresenter;
    public HumidityInteractor(HumidityDataAccessInterface humidityDataAccessObject, HumidityOutputBoundary humidityOutputBoundary) {
        this.humidityDataAccessObject = humidityDataAccessObject;
        this.humidityPresenter = humidityOutputBoundary;
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
}
