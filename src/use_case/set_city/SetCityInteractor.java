package use_case.set_city;

import use_case.set_city.SetCityInputBoundary;

public class SetCityInteractor {

    final SetCityOutputBoundary setCityPresenter;
    final SetCityDataAccessInterface setCityDataAccessObject;

    public SetCityInteractor(SetCityOutputBoundary setCityPresenter, SetCityDataAccessInterface setCityDataAccessObject) {
        this.setCityPresenter = setCityPresenter;
        this.setCityDataAccessObject = setCityDataAccessObject;
    }

    public void execute(SetCityInputBoundary setCityInputData){

    }
}
