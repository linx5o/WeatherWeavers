package use_case.forecast;

public interface ForecastOutputBoundary {
    void prepareInformationForecast(ForecastOutputData forecast);
    void prepareForecast(ForecastOutputData forecast);
}
