package use_case.weather;

public interface GetWeatherOutputBoundary {
    void prepareSuccessView(GetWeatherOutputData getWeatherOutputData);

    void prepareFailView(String error);
}
