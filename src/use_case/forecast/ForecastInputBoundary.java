package use_case.forecast;

public interface ForecastInputBoundary {
    void execute(ForecastInputData forecastInputData);

    void execute(int days, boolean information);
}
