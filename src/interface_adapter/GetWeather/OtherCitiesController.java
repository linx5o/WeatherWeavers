package interface_adapter.GetWeather;

import use_case.get_other_cities.GetOtherCitiesInputBoundary;
import use_case.get_other_cities.GetOtherCitiesInputData;

import java.time.LocalTime;

public class OtherCitiesController {

    private final GetOtherCitiesInputBoundary getOtherCitiesInteractor;
    public OtherCitiesController(GetOtherCitiesInputBoundary getOtherCitiesInteractor) {
        this.getOtherCitiesInteractor = getOtherCitiesInteractor;
    }

    public void execute(LocalTime localTime){
        getOtherCitiesInteractor.execute(localTime);
    }
}
