package use_case.set_default_city;

public class SetDefaultCityInteractor implements SetDefaultCityInputBoundary{

        final SetDefaultCityOutputBoundary setDefaultCityPresenter;
        final SetDefaultCityDataAccessInterface setDefaultCityDataAccessObject;

        public SetDefaultCityInteractor(SetDefaultCityOutputBoundary setDefaultCityPresenter, SetDefaultCityDataAccessInterface setDefaultCityDataAccessObject) {
            this.setDefaultCityPresenter = setDefaultCityPresenter;
            this.setDefaultCityDataAccessObject = setDefaultCityDataAccessObject;
        }

        @Override
        public void execute(SetDefaultCityInputData setDefaultCityInputData) {
            if (setDefaultCityDataAccessObject.setDefaultCity(setDefaultCityInputData.getCityName())) {
                SetDefaultCityOutputData setDefaultCityOutputdata = new SetDefaultCityOutputData(setDefaultCityInputData.getCityName());
                setDefaultCityPresenter.prepareSuccessView(setDefaultCityOutputdata);
            } else {
                setDefaultCityPresenter.prepareFailView("Fail to set. City weather data is not found.");
            }

        }

}
