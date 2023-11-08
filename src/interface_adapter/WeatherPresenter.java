package interface_adapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WeatherPresenter {
    private final WeatherViewModel weatherViewModel;

    private ViewManagerModel viewManagerModel;

    public WeatherPresenter(ViewManagerModel viewManagerModel,
                           WeatherViewModel weatherViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.weatherViewModel = weatherViewModel;
    }

    @Override
    public void prepareSuccessView(weatherOutputData response) {
        // On success, switch to the login view.
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        WeatherState weatherState = weatherViewModel.getState();
        this.weatherViewModel.setState(weatherState);
        weatherViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(weatherViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        WeatherState weatherState = WeatherViewModel.getState();
        weatherState.setUsernameError(error);
        weatherViewModel.firePropertyChanged();
    }
}
