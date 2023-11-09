package use_case.set_city;

public interface SetCityOutputBoundary {

    void prepareSuccessView(SetCityOutputData outputData);

    void prepareFailView(String error);
}
