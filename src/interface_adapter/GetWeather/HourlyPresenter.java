package interface_adapter.GetWeather;

import use_case.hourly.HourlyOutputBoundary;
import use_case.hourly.HourlyOutputData;

public class HourlyPresenter implements HourlyOutputBoundary {
    public HourlyPresenter(HourlyViewModel hourlyViewModel) {
    }

    @Override
    public void prepareSuccessView(HourlyOutputData hourlyOutputData) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
