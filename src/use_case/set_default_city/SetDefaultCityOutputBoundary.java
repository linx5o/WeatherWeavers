package use_case.set_default_city;

public interface SetDefaultCityOutputBoundary {

        void prepareSuccessView(SetDefaultCityOutputData setDefaultCityOutputData);

        void prepareFailView(String error);
}
