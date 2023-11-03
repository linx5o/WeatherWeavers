package use_case.weather;

public interface weatherOutputBoundary {
    void prepareSuccessView(weatherOutputData weatherOutputData);

    void prepareFailView(String error);
}
