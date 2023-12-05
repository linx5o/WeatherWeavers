package use_case.set_city;

import use_case.set_city.SetCityInputBoundary;

public class SetCityInteractor implements SetCityInputBoundary{

    final SetCityOutputBoundary setCityPresenter;
    final SetCityDataAccessInterface setCityDataAccessObject;

    public SetCityInteractor(SetCityOutputBoundary setCityPresenter, SetCityDataAccessInterface setCityDataAccessObject) {
        this.setCityPresenter = setCityPresenter;
        this.setCityDataAccessObject = setCityDataAccessObject;
    }

    @Override
    public void execute(SetCityInputData setCityInputData){
        int response = setCityDataAccessObject.addCity(setCityInputData.getCity());
        if (response == 0) {
            SetCityOutputData setCityOutputData = new SetCityOutputData(setCityDataAccessObject.getSettings().getSavedCities());
            setCityPresenter.prepareSuccessView(setCityOutputData, "Successfully set city!");
        }
        else if (response == 1) {
            setCityPresenter.prepareFailView("Fail to add. City already exists.");
        }
        else if (response == 2) {
            setCityPresenter.prepareFailView("Fail to add. City is the default city.");
        }
        else if (response == 3) {
            setCityPresenter.prepareFailView("Fail to add. City weather data is not found.");
        }
        else if (response == 4){
            setCityPresenter.prepareFailView("Fail to add. Saved cities reached max number.");
        }
        else {
            setCityPresenter.prepareFailView("Fail to add. Unknown error.");
        }
    }
}
