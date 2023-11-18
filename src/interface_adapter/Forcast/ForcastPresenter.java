package interface_adapter.Forcast;

import interface_adapter.ViewManagerModel;
import use_case.forecast.ForcastOutputBoundary;
import use_case.forecast.ForcastOutputData;

public class ForcastPresenter implements ForcastOutputBoundary {
    private final ForcastViewModel forcastViewModel;
    private ViewManagerModel viewManagerModel;

    public ForcastPresenter(ViewManagerModel viewManagerModel,
            ForcastViewModel forcastViewModel) {
        this.forcastViewModel = forcastViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareInformationForcast(ForcastOutputData forcast) {

    }

    @Override
    public void prepareForcast(ForcastOutputData forcast) {

    }
}
