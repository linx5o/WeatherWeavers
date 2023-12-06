package app;

import interface_adapter.Forecast.ForecastController;
import interface_adapter.Forecast.ForecastPresenter;
import interface_adapter.Forecast.ForecastViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import use_case.forecast.ForecastDataAccessInterface;
import use_case.forecast.ForecastInputBoundary;
import use_case.forecast.ForecastInteractor;
import use_case.forecast.ForecastSettingsDataAccessInterface;
import view.weather.ForecastView;

import static org.mockito.Mockito.when;

public class ForecastUseCaseFactoryTest {
    @BeforeEach
    public void setUp() {
        ForecastController forecastController = Mockito.mock(interface_adapter.Forecast.ForecastController.class);
        ForecastPresenter forecastPresenter = Mockito.mock(interface_adapter.Forecast.ForecastPresenter.class);
        ForecastViewModel forecastViewModel = Mockito.mock(interface_adapter.Forecast.ForecastViewModel.class);
        ForecastView forecastView = Mockito.mock(view.weather.ForecastView.class);
        ForecastDataAccessInterface forecastDataAccessObject = Mockito.mock(use_case.forecast.ForecastDataAccessInterface.class);
        ForecastSettingsDataAccessInterface getSettingsDataAccessObject = Mockito.mock(use_case.forecast.ForecastSettingsDataAccessInterface.class);
    }

    @Test
    public void testCreate() {

    }
}

