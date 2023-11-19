package use_case.humidity;

public interface HumidityOutputBoundary {
    void prepareSuccessView(HumidityOutputData humidityOutputData);

    void prepareFailView(String error);
}
