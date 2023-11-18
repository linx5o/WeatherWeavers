package use_case.hourly;

public interface HourlyOutputBoundary {
    void prepareSuccessView(HourlyOutputData hourlyOutputData);

    void prepareFailView(String error);
}
