package use_case.forecast;

import entity.Location;
import entity.Weather;

import java.util.List;

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
        Location location = forcastInputData.getLocation();
        int days = forcastInputData.getDays();
        boolean information = forcastInputData.isInformation();
        List<Weather> forcastList = forecastDataAccessObject.getForecast(location, days);
        if (information){
            ForcastOutputData forcastOutputData = new ForcastOutputData(days, forcastList, true);
            forecastPresenter.prepareInformationForcast(forcastOutputData);
        } else {
            ForcastOutputData forcastOutputData = new ForcastOutputData(days, forcastList, false);
            forecastPresenter.prepareForcast(forcastOutputData);
        }
    }
}
