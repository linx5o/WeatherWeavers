package use_case.erase_city;

import use_case.erase_city.EraseCityOutputData;

public interface EraseCityOutputBoundary {

    void prepareSuccessView(EraseCityOutputData eraseCityOutputData, String success);

    void prepareFailView(String error);
}
