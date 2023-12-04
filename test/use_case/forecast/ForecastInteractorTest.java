//package use_case.forecast;
//
//import data_access.ForecastDataAccessObject;
//import data_access.GetSettingsDataAccessObject;
//import interface_adapter.Forecast.ForecastPresenter;
//import org.junit.Before;
//import org.mockito.Mock;
//
//
//public class ForecastInteractorTest {
//    private ForecastDataAccessInterface forecastDataAccessObject;
//    private ForecastOutputBoundary forecastPresenter;
//    private ForecastSettingsDataAccessInterface forecastSettingsDataAccessObject;
//
//    @Mock
//    private ForecastInteractor forecastInteractor;
//
//    @Before
//    public void setUp() {
//        forecastDataAccessObject = new ForecastDataAccessObject();
//        forecastPresenter = new ForecastPresenter();
//        forecastSettingsDataAccessObject = new GetSettingsDataAccessObject();
//        forecastInteractor = new ForecastInteractor(forecastDataAccessObject, forecastSettingsDataAccessObject, forecastPresenter);
//    }
//}
