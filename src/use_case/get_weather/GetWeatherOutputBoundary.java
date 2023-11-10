package use_case.get_weather;

public interface GetWeatherOutputBoundary {
    void prepareSuccessView(GetWeatherOutputData getWeatherOutputData);

    void prepareFailView(String error);
}
