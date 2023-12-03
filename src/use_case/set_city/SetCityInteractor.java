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
        if (setCityDataAccessObject.addCity(setCityInputData.getCity()) == 0) {
            SetCityOutputData setCityOutputData = new SetCityOutputData(setCityInputData.getCity());
            setCityPresenter.prepareSuccessView(setCityOutputData, "Successfully set city!");
        }
        else if (setCityDataAccessObject.addCity(setCityInputData.getCity()) == 1) {
            setCityPresenter.prepareFailView("Fail to add. City already exists.");
        }
        else if (setCityDataAccessObject.addCity(setCityInputData.getCity()) == 2) {
            setCityPresenter.prepareFailView("Fail to add. City is the default city.");
        }
        else {
            setCityPresenter.prepareFailView("Fail to add. City weather data is not found.");
        }
    }
}
