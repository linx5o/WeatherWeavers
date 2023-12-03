package use_case.set_city;

public interface SetCityOutputBoundary {

    void prepareSuccessView(SetCityOutputData setCityOutputData, String success);

    void prepareFailView(String error);
}
