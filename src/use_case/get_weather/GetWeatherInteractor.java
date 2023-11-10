package use_case.get_weather;

public class GetWeatherInteractor implements GetWeatherInputBoundary{

    final GetWeatherDataAccessInterface getWeatherDataAccessObject;
    final GetWeatherOutputBoundary getWeatherPresenter;

    public GetWeatherInteractor(GetWeatherDataAccessInterface getWeatherDataAccessObject, GetWeatherOutputBoundary getWeatherPresenter) {
        this.getWeatherDataAccessObject = getWeatherDataAccessObject;
        this.getWeatherPresenter = getWeatherPresenter;
    }

    @Override
    public void execute(GetWeatherInputData getWeatherInputData) {

    }

}
