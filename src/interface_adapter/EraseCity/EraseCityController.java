package interface_adapter.EraseCity;

import use_case.erase_city.EraseCityInputBoundary;
import use_case.erase_city.EraseCityInputData;

public class EraseCityController {
    final EraseCityInputBoundary eraseCityUseCaseInteractor;

    public EraseCityController(EraseCityInputBoundary eraseCityUseCaseInteractor) {
        this.eraseCityUseCaseInteractor = eraseCityUseCaseInteractor;
    }

    public void execute(String city) {
        eraseCityUseCaseInteractor.execute(new EraseCityInputData(city));
    }
}
