package use_case.forecast;

public class ForcastInteractor implements ForcastInputBoundary{
    final ForecastDataAccessInterface forecastDataAccessObject;
    final ForcastOutputBoundary forecastPresenter;

    public ForcastInteractor(ForecastDataAccessInterface forecastDataAccessObject,
                             ForcastOutputBoundary forecastPresenter) {
        this.forecastDataAccessObject = forecastDataAccessObject;
        this.forecastPresenter = forecastPresenter;
    }

    @Override
    public void execute(ForcastInputData forcastInputData) {

    }
}
