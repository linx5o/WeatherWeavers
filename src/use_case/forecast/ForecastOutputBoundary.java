package use_case.forecast;

public interface ForecastOutputBoundary {
    void prepareInformationForcast(ForecastOutputData forcast);
    void prepareForcast(ForecastOutputData forcast);
}
