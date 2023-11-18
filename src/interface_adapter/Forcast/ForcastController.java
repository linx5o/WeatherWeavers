package interface_adapter.Forcast;

import entity.Location;
import use_case.forecast.ForcastInputBoundary;
import use_case.forecast.ForcastInputData;

public class ForcastController {
    final ForcastInputBoundary forcastUseCaseInteractor;

    public ForcastController(ForcastInputBoundary forcastUseCaseInteractor) {
        this.forcastUseCaseInteractor = forcastUseCaseInteractor;
    }

    public void execute(Location location, int days, boolean information){
        ForcastInputData forcastInputData = new ForcastInputData(location, days, information);
        forcastUseCaseInteractor.execute(forcastInputData);
    }
}
