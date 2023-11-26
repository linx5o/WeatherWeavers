package interface_adapter.GetWeather;

import use_case.get_other_cities.GetOtherCitiesOutputBoundary;
import use_case.get_other_cities.GetOtherCitiesOutputData;

public class OtherCitiesPresenter implements GetOtherCitiesOutputBoundary {
    public OtherCitiesPresenter(OtherCitiesViewModel otherCitiesViewModel) {
    }

    @Override
    public void presentOtherCitiesWeather(GetOtherCitiesOutputData response) {

    }
}
