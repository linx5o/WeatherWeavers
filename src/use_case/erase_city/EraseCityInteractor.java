package use_case.erase_city;

import use_case.erase_city.EraseCityDataAccessInterface;
import use_case.erase_city.EraseCityInputData;
import use_case.erase_city.EraseCityOutputBoundary;
import use_case.erase_city.EraseCityOutputData;

public class EraseCityInteractor implements EraseCityInputBoundary {

    final EraseCityOutputBoundary eraseCityPresenter;
    final EraseCityDataAccessInterface eraseCityDataAccessObject;

    public EraseCityInteractor(EraseCityOutputBoundary eraseCityPresenter, EraseCityDataAccessInterface eraseCityDataAccessObject) {
        this.eraseCityPresenter = eraseCityPresenter;
        this.eraseCityDataAccessObject = eraseCityDataAccessObject;
    }

    @Override
    public void execute(EraseCityInputData eraseCityInputData){
        if (eraseCityDataAccessObject.eraseCity(eraseCityInputData.getCity())) {
            EraseCityOutputData eraseCityOutputData = new EraseCityOutputData(eraseCityDataAccessObject.getSettings().getSavedCities());
            eraseCityPresenter.prepareSuccessView(eraseCityOutputData, "Successfully remove city!");
        }
        else {
            eraseCityPresenter.prepareFailView("Fail to remove. City is not saved.");
        }
    }
}
