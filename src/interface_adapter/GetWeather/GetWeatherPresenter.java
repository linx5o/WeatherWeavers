package interface_adapter.GetWeather;

import use_case.get_weather.GetWeatherOutputBoundary;
import use_case.get_weather.GetWeatherOutputData;

public class GetWeatherPresenter implements GetWeatherOutputBoundary {
    private final GetWeatherViewModel getWeatherViewModel;

    public GetWeatherPresenter(GetWeatherViewModel getWeatherViewModel) {
        this.getWeatherViewModel = getWeatherViewModel;
    }

    @Override
    public void prepareSuccessView(GetWeatherOutputData getWeatherOutputData) {
        // TODO
    }

    @Override
    public void prepareFailView(String error) {
        // TODO
    }
}
