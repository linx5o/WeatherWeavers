package interface_adapter.SetDefaultCity;

import use_case.set_default_city.SetDefaultCityInputBoundary;
import use_case.set_default_city.SetDefaultCityInputData;

public class SetDefaultCityController {
    final SetDefaultCityInputBoundary setDefaultCityUseCaseInteractor;

    public SetDefaultCityController(SetDefaultCityInputBoundary setDefaultCityUseCaseInteractor) {
        this.setDefaultCityUseCaseInteractor = setDefaultCityUseCaseInteractor;
    }

    public void execute(String city) {
        setDefaultCityUseCaseInteractor.execute(new SetDefaultCityInputData(city));
    }
}
