package interface_adapter.SetCity;

import use_case.set_city.SetCityInputBoundary;
import use_case.set_city.SetCityInputData;

public class SetCityController {
    final SetCityInputBoundary setCityUseCaseInteractor;

    public SetCityController(SetCityInputBoundary setCityUseCaseInteractor) {
        this.setCityUseCaseInteractor = setCityUseCaseInteractor;
    }

    public void execute(String city) {
        setCityUseCaseInteractor.execute(new SetCityInputData(city));
    }
}
